package com.httt1.vietnamtravel.favorite.model;

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

public class FavoriteTourRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public FavoriteTourRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public FavoriteTourRepository(SQLServerDataSource sqlServerDataSource) {
        this.sqlServerDataSource = sqlServerDataSource;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    // Callback interfaces
    public interface FavoriteTourCallBack {
        void listFavoriteTour(List<FavoriteModel> listFavoriteTour);
    }

    // Method to get favorite tours
    public void getFavoriteTours(int userId, FavoriteTourCallBack favoriteTourCallBack) {
        executorService.execute(() -> {
            String query = "SELECT FavTour.IdUser, Tour.IdTour, Tour.TypeTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, " +
                            "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite " +
                            "FROM Tour " +
                            "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                            "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour AND FavTour.IdUser = ? " +
                            "WHERE ImgTour.ImgPosition = 1 AND FavTour.IdUser = ?";

            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, userId);
                ResultSet resultSet = statement.executeQuery();
                List<FavoriteModel> list = setDataFavoriteTour(resultSet);
                favoriteTourCallBack.listFavoriteTour(list);
                Log.d("Tour count: ", "Favorite tour count: " + list.size());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private List<FavoriteModel> setDataFavoriteTour(ResultSet resultSet) throws SQLException {
        List<FavoriteModel> favtours = new ArrayList<>();
        while (resultSet.next()) {
            int tourId = resultSet.getInt("IdTour");
            String nameTour = resultSet.getString("NameTour");
            int priceTour = resultSet.getInt("PriceTour");
            String imgUrl = resultSet.getString("ImgResource");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Convert isFavorite value from int to boolean
            boolean favorite = isFavorite != 0;

            FavoriteModel favtour = new FavoriteModel(tourId, imgUrl, nameTour, priceTour, favorite);
            favtours.add(favtour);
        }
        return favtours;
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
