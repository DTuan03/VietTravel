package com.httt.viettravel.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.httt.viettravel.Connection.SQL.ConnectSQL;

public class TourReponsitory {

    public List<Tour> getUnratedTours() {
        List<Tour> tourList = new ArrayList<>();

        try {
            // Kết nối đến SQL Server
            Connection connection = ConnectSQL.CONN();

            // Câu truy vấn SQL
            String query = "SELECT T.IdTour, T.TypeTour, T.NameTour, T.DescriptionTour, T.NumberDay,T.PriceTour, BT.Total, T.FavTour, T.Hotel, T.Vehicle, T.Propose, T.NotMissed " +
                    "FROM Tour T " +
                    "JOIN BookedTour BT ON T.IdTour = BT.IdTour " +
                    "LEFT JOIN Feedback F ON BT.IdBookedTour = F.IdBookedTour " +
                    "WHERE F.IdFeedback IS NULL;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String idTour = resultSet.getString("IdTour");
                String typeTour = resultSet.getString("TypeTour");
                String nameTour = resultSet.getString("NameTour");
                String descriptionTour = resultSet.getString("DescriptionTour");
                int numberDay = resultSet.getInt("NumberDay");
                float total = resultSet.getFloat("Total");
                float priceTour = resultSet.getFloat("PriceTour");
                boolean favTour = resultSet.getBoolean("FavTour");
                String hotel = resultSet.getString("Hotel");
                String vehicle = resultSet.getString("Vehicle");
                boolean propose = resultSet.getBoolean("Propose");
                boolean notMissed = resultSet.getBoolean("NotMissed");

                Tour tour = new Tour(idTour, typeTour, nameTour, descriptionTour, numberDay, priceTour,total, favTour, hotel, vehicle, propose, notMissed);
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



