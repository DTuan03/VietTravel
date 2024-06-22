package com.httt.viettravel.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.httt.viettravel.Connection.SQL.ConnectSQL;

public class TourReponsitory {

    public List<Tour> getUnratedTours() {
        List<Tour> tourList = new ArrayList<>();
        String idUser = "User1";

        try {
            // Kết nối đến SQL Server
            Connection connection = ConnectSQL.CONN();
//            String query = "SELECT t.* FROM Tour t WHERE t.IdTour NOT IN " +
//                    "(SELECT bt.IdTour FROM BookedTour bt JOIN Feedback f ON bt.IdBookedTour = f.IdBookedTour " +
//                    "WHERE bt.IdUser = '" + idUser + "') AND EXISTS (SELECT 1 FROM BookedTour bt WHERE bt.IdUser = '" + idUser + "' AND bt.IdTour = t.IdTour)";

            String query = "SELECT T.*, BT.*, IT.ImgResource " +
                    "FROM Tour T " +
                    "JOIN BookedTour BT ON T.IdTour = BT.IdTour " +
                    "LEFT JOIN Feedback F ON BT.IdBookedTour = F.IdBookedTour " +
                    "LEFT JOIN Img_Tour ITT ON T.IdTour = ITT.IdTour " +
                    "LEFT JOIN ImgTour IT ON ITT.IdImg = IT.IdImg " +
                    "WHERE F.IdBookedTour IS NULL AND ITT.ImgMain = 1 AND BT.IdUser = '" + idUser + "'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            while (resultSet.next()) {
                String idTour = resultSet.getString("IdTour");
                String typeTour = resultSet.getString("TypeTour");
                String nameTour = resultSet.getString("NameTour");
                String descriptionTour = resultSet.getString("DescriptionTour");
                int numberDay = resultSet.getInt("NumberDay");
                float total = resultSet.getFloat("Total");
                float priceTour = resultSet.getFloat("PriceTour");
                Date startDay = formatter.parse(resultSet.getString("StartDay"));
                Date endDay = formatter.parse(resultSet.getString("EndDay"));
                String hotel = resultSet.getString("Hotel");
                String vehicle = resultSet.getString("Vehicle");
                String idBookedTour = resultSet.getString(("idBookedTour"));
                String ImgResource = resultSet.getString("ImgResource");
                Tour tour = new Tour(idTour, typeTour, nameTour, descriptionTour, numberDay, priceTour,total,startDay,endDay, hotel, vehicle, idBookedTour, ImgResource);
                tourList.add(tour);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tourList;
    }
}



