package com.httt.viettravel.History.Rated.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.httt.viettravel.Connection.SQL.ConnectSQL;

public class RatedRepository {

    public List<Rated> getAllFeedback() {
        List<Rated> ratedList = new ArrayList<>();
        String idUser = "1"; // Thay thế idUser bằng ID người dùng hiện tại
        try {
            Connection connection = ConnectSQL.CONN();

            String query = "SELECT F.*, IT.ImgResource, U.Username, T.NameTour " +
                    "FROM Feedback F " +
                    "JOIN BookedTour BT ON F.IdBookedTour = BT.IdBookedTour " +
                    "JOIN Tour T ON BT.IdTour = T.IdTour " +
                    "JOIN Users U ON BT.IdUser = U.IdUser " +
                    "LEFT JOIN ImgTour IT ON T.IdTour = IT.IdTour " +
                    "WHERE IT.ImgPosition = 1 AND BT.IdUser = '" + idUser + "'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            while (resultSet.next()) {
                String idFeedback = resultSet.getString("IdFeedback");
                String idBookedTour = resultSet.getString("IdBookedTour");
                String descriptionFeedback = resultSet.getString("DescriptionFeedback");
                int rating = resultSet.getInt("Rating");
                String dateOfFeedback = resultSet.getString("DateOfFeedback");
                String timeOfFeedback = resultSet.getString("TimeOfFeedback");
                String imgMainResource = resultSet.getString("ImgResource");
                String userName = resultSet.getString("Username");
                String nameTour = resultSet.getString("NameTour");

                List<String> imageUrls = getImageUrlsForFeedback(idFeedback, connection);

                Rated rated = new Rated(idFeedback, idBookedTour, descriptionFeedback, rating, dateOfFeedback, timeOfFeedback, userName, nameTour, imageUrls, imgMainResource);
                ratedList.add(rated);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ratedList;
    }
    //Lấy tất cả các ảnh để hiển ở phía trên trên.
    private List<String> getImageUrlsForFeedback(String idFeedback, Connection connection) {
        List<String> imageUrls = new ArrayList<>();  //ds rỗng để lưu ảnh
        try {
            String query = "SELECT ImgResource FROM ImgFeedback WHERE IdFeedback = " + idFeedback;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String imagePath = resultSet.getString("ImgResource");
                imageUrls.add(imagePath);
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageUrls;
    }
}
