package com.httt1.vietnamtravel.History.Rated.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

public class RatedRepository {

    private static final Logger logger = Logger.getLogger(RatedRepository.class.getName());

    public List<Rated> getAllFeedback() {
        List<Rated> ratedList = new ArrayList<>();
        String idUser = "3"; // Replace idUser with the current user ID
        SQLServerDataSource dataSource = new SQLServerDataSource();

        String query = "SELECT F.*, IT.ImgResource, U.Username, U.UserImg, T.NameTour " +
                "FROM Feedback F " +
                "JOIN BookedTour BT ON F.IdBookedTour = BT.IdBookedTour " +
                "JOIN Tour T ON BT.IdTour = T.IdTour " +
                "JOIN Users U ON BT.IdUser = U.IdUser " +
                "LEFT JOIN ImgTour IT ON T.IdTour = IT.IdTour " +
                "WHERE IT.ImgPosition = 1 AND BT.IdUser = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, idUser);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
                    String imgUser = resultSet.getString("UserImg");

                    List<String> imageUrls = getImageUrlsForFeedback(idFeedback, connection);

                    Rated rated = new Rated(idFeedback, idBookedTour, descriptionFeedback, rating, dateOfFeedback, timeOfFeedback, userName, nameTour, imageUrls, imgMainResource, imgUser);
                    ratedList.add(rated);
                }
            }
        } catch (Exception e) {
            logger.severe("Error fetching feedback: " + e.getMessage());
        }

        return ratedList;
    }

    private List<String> getImageUrlsForFeedback(String idFeedback, Connection connection) {
        List<String> imageUrls = new ArrayList<>();
        String query = "SELECT ImgResource FROM ImgFeedback WHERE IdFeedback = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idFeedback);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String imagePath = resultSet.getString("ImgResource");
                    imageUrls.add(imagePath);
                }
            }
        } catch (Exception e) {
            logger.severe("Error fetching image URLs: " + e.getMessage());
        }

        return imageUrls;
    }
}
