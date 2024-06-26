package com.httt.viettravel.History.Unrated.Model;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.httt.viettravel.Connection.SQL.ConnectSQL;

public class TourRepository {

    public List<Tour> getUnratedTours() {
        List<Tour> tourList = new ArrayList<>();
        String idUser = "1"; // Gán cứng idUser

        try {
            Connection connection = ConnectSQL.CONN();

            String query = "SELECT T.*, BT.StartDay, BT.EndDay, BT.Total, BT.IdBookedTour, IT.ImgResource, IT.ImgPosition " +
                    "FROM Tour T " +
                    "JOIN BookedTour BT ON T.IdTour = BT.IdTour " +
                    "LEFT JOIN Feedback F ON BT.IdBookedTour = F.IdBookedTour " +
                    "LEFT JOIN ImgTour IT ON T.IdTour = IT.IdTour AND IT.ImgPosition = 1 " +
                    "WHERE F.IdFeedback IS NULL AND BT.IdUser = '" + idUser + "'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            while (resultSet.next()) {
                String idTour = resultSet.getString("IdTour");
                String typeTour = resultSet.getString("TypeTour");
                String nameTour = resultSet.getString("NameTour");
                String descriptionTour = resultSet.getString("DescriptionTour");
                int numberDay = resultSet.getInt("NumberDay");
                int total = resultSet.getInt("Total");
                Date startDay = formatter.parse(resultSet.getString("StartDay"));
                Date endDay = formatter.parse(resultSet.getString("EndDay"));
                String hotel = resultSet.getString("Hotel");
                String vehicle = resultSet.getString("Vehicle");
                String idBookedTour = resultSet.getString("IdBookedTour");
                String imgMainResource = resultSet.getString("ImgResource");

                Tour tour = new Tour(idTour, typeTour, nameTour, descriptionTour, numberDay, total, startDay, endDay, hotel, vehicle, idBookedTour, imgMainResource);
                tourList.add(tour);
            }

            resultSet.close();
            statement.close();
            connection.close();

            Log.d("TourRepository", "Number of unrated tours: " + tourList.size());

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TourRepository", "Error retrieving unrated tours", e);
        }

        return tourList;
    }
}
