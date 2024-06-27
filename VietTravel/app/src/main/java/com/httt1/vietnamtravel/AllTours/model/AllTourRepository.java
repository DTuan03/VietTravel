package com.httt1.vietnamtravel.AllTours.model;

import android.util.Log;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AllTourRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public AllTourRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }


    // Callback interfaces
    public interface AllTourCallBack {
        void listAllTour(List<AllTourModel> listAllTour);
    }

    // Method to get all tours
    public void getAllTour(int userId, AllTourCallBack allTourCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Tour.IdTour, Tour.TypeTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, " +
                        "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite " +
                        "FROM Tour " +
                        "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                        "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour AND FavTour.IdUser = ? " +
                        "WHERE ImgTour.ImgPosition = 1";
                try (Connection connection = sqlServerDataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    List<AllTourModel> list = setDataAllTour(resultSet);
                    allTourCallBack.listAllTour(list);
                    Log.d("So luong tour: ", "So luong tour yeu thich: " + list.size());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private List<AllTourModel> setDataAllTour(ResultSet resultSet) throws SQLException {
        List<AllTourModel> alltours = new ArrayList<>();
        while (resultSet.next()) {
            int tourId = resultSet.getInt("IdTour");
            String nameTour = resultSet.getString("NameTour");
            int priceTour = resultSet.getInt("PriceTour");
            String imgUrl = resultSet.getString("ImgResource");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Chuyển đổi giá trị isFavorite từ int sang boolean
            boolean favorite = isFavorite != 0;

            AllTourModel alltour = new AllTourModel(tourId, imgUrl, nameTour, priceTour, favorite);
            alltours.add(alltour);
        }
        return alltours;
    }

    public void addFavorite(int userId, int tourId) {
        executorService.execute(() -> {
            String query = "INSERT INTO FavTour (IdUser, IdTour) VALUES (?, ?)";
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, tourId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void removeFavorite(int userId, int tourId) {
        executorService.execute(() -> {
            String query = "DELETE FROM FavTour WHERE IdUser = ? AND IdTour = ?";
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, tourId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
