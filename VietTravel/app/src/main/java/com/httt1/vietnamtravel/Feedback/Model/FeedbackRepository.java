package com.httt1.vietnamtravel.Feedback.Model;

import android.os.AsyncTask;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FeedbackRepository {

    private static final Logger logger = Logger.getLogger(FeedbackRepository.class.getName());

    public interface FeedbackCallback {
        void onFeedbackLoaded(List<Feedback> feedbackList);
        void onError(Exception e);
    }

    public void getAllFeedback(String idUser, FeedbackCallback callback) {
        new LoadFeedbackTask(idUser, callback).execute();
    }

    private static class LoadFeedbackTask extends AsyncTask<Void, Void, List<Feedback>> {
        private String idUser;
        private FeedbackCallback callback;
        private Exception exception;

        LoadFeedbackTask(String idUser, FeedbackCallback callback) {
            this.idUser = idUser;
            this.callback = callback;
        }

        @Override
        protected List<Feedback> doInBackground(Void... voids) {
            List<Feedback> feedbackList = new ArrayList<>();
            SQLServerDataSource dataSource = new SQLServerDataSource();

            String query = "SELECT F.*, IT.ImgResource, U.Username, T.NameTour " +
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

                        List<String> imageUrls = getImageUrlsForFeedback(idFeedback, connection);

                        Feedback feedback = new Feedback(idFeedback, idBookedTour, descriptionFeedback, rating, dateOfFeedback, timeOfFeedback, userName, nameTour, imageUrls, imgMainResource);
                        feedbackList.add(feedback);
                    }
                }
            } catch (Exception e) {
                this.exception = e;
                logger.severe("Error fetching feedback: " + e.getMessage());
            }

            return feedbackList;
        }

        @Override
        protected void onPostExecute(List<Feedback> feedbackList) {
            if (exception != null) {
                callback.onError(exception);
            } else {
                callback.onFeedbackLoaded(feedbackList);
            }
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
}
