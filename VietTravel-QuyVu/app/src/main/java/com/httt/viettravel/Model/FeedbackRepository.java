package com.httt.viettravel.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.httt.viettravel.Connection.SQL.ConnectSQL;

public class FeedbackRepository {

    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String idUser = "User1";
        try {
            // Kết nối đến SQL Server
            Connection connection = ConnectSQL.CONN();

            // Câu truy vấn SQL
//            String query = "SELECT * FROM Feedback";
            // Câu truy vấn SQL để lấy đánh giá và ảnh chính
            String query = "SELECT F.*, IT.ImgResource, U.Username, T.NameTour " +
                    "FROM Feedback F " +
                    "JOIN BookedTour BT ON F.IdBookedTour = BT.IdBookedTour " +
                    "JOIN Tour T ON BT.IdTour = T.IdTour " +
                    "JOIN Users U ON BT.IdUser = U.IdUser " +
                    "LEFT JOIN Img_Tour ITT ON T.IdTour = ITT.IdTour " +
                    "LEFT JOIN ImgTour IT ON ITT.IdImg = IT.IdImg " +
                    "WHERE ITT.ImgMain = 1 AND BT.IdUser = '" + idUser + "'";

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
                String imgMainResource = resultSet.getString("ImgResource"); //Thêm để lấy ảnh tour
                String UserName = resultSet.getString("Username");
                String NameTour = resultSet.getString("NameTour");//Thêm để lấy ảnh tour
                Feedback feedback = new Feedback(idFeedback, idBookedTour, descriptionFeedback, rating, dateOfFeedback, timeOfFeedback, imgMainResource, UserName,NameTour);
//                feedback.setImgMainResource(imgMainResource); // Cập nhật ảnh chính
                feedbackList.add(feedback);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return feedbackList;
    }
}
