package com.httt1.vietnamtravel.BookTour.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookTourRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public BookTourRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface BookTourCallBack {
        void onBookTourLoaded(HomeModel bookTour);
    }

    public void getBookTour(int userId, int tourId, BookTourCallBack bookTourCallBack) {
        executorService.execute(() -> {
            String query = "SELECT Tour.IdTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource " +
                    "FROM Tour " +
                    "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                    "WHERE Tour.IdTour = ? " +
                    "ORDER BY ImgTour.ImgPosition ASC LIMIT 1";
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tourId);
                ResultSet resultSet = statement.executeQuery();

                HomeModel bookTour = null;
                if (resultSet.next()) {
                    int id = resultSet.getInt("IdTour");
                    String name = resultSet.getString("NameTour");
                    int price = resultSet.getInt("PriceTour");
                    String imgUrl = resultSet.getString("ImgResource");

                    bookTour = new HomeModel(id, imgUrl, name, price); // Assuming number of days is not needed here
                }

                bookTourCallBack.onBookTourLoaded(bookTour);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
