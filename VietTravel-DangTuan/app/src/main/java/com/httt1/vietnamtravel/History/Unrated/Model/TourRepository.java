package com.httt1.vietnamtravel.History.Unrated.Model;

import android.os.AsyncTask;
import android.util.Log;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TourRepository {

    private static final String TAG = "TourRepository";
    //Truyền lại kết quả truy vấn
    public interface TourRepositoryCallback {
        void onUnratedToursLoaded(List<Tour> tours);
        void onError(Exception e);
    }
    //Chạy Asynctask lấy dữ liệu truyền
    public void getUnratedTours(String idUser, TourRepositoryCallback callback) {
        new LoadUnratedToursTask(idUser, callback).execute();
    }

    private static class LoadUnratedToursTask extends AsyncTask<Void, Void, List<Tour>> {

        private String idUser;
        private TourRepositoryCallback callback;
        private Exception exception;

        LoadUnratedToursTask(String idUser, TourRepositoryCallback callback) {
            this.idUser = idUser;
            this.callback = callback;
        }
        //Truy vấn csdl
        @Override
        protected List<Tour> doInBackground(Void... voids) {
            List<Tour> tourList = new ArrayList<>();
            String query = "SELECT T.*, BT.StartDay, BT.EndDay, BT.Total, BT.IdBookedTour, IT.ImgResource " +
                    "FROM Tour T " +
                    "JOIN BookedTour BT ON T.IdTour = BT.IdTour " +
                    "LEFT JOIN Feedback F ON BT.IdBookedTour = F.IdBookedTour " +
                    "LEFT JOIN ImgTour IT ON T.IdTour = IT.IdTour AND IT.ImgPosition = 1 " +
                    "WHERE F.IdFeedback IS NULL AND BT.IdUser = ?";

            SQLServerDataSource dataSource = new SQLServerDataSource();

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, idUser);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
                }

            } catch (Exception e) {
                this.exception = e;
                Log.e(TAG, "Error retrieving unrated tours", e);
            }

            return tourList;
        }

        @Override
        protected void onPostExecute(List<Tour> tours) {
            if (exception != null) {
                callback.onError(exception);
            } else {
                callback.onUnratedToursLoaded(tours);
            }
        }
    }
}
