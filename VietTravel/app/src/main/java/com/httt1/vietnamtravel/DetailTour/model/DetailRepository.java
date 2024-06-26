package com.httt1.vietnamtravel.DetailTour.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DetailRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public DetailRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface DetailCallBack {
        void onDetailTourLoaded(DetailModel detailTour);
    }

    public void getDetailTour(int userId, int tourId, DetailCallBack detailCallBack) {
        executorService.execute(() -> {
            String query = "SELECT Tour.IdTour, Tour.NameTour, Tour.PriceTour, Tour.DescriptionTour, " +
                    "Tour.NumberDay, Tour.Hotel, Tour.Vehicle, ImgTour.ImgResource, " +
                    "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite " +
                    "FROM Tour " +
                    "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                    "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour AND FavTour.IdUser = ? " +
                    "WHERE Tour.IdTour = ? " +
                    "ORDER BY ImgTour.ImgPosition";
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, tourId);
                ResultSet resultSet = statement.executeQuery();

                DetailModel detailTour = null;
                List<String> imageUrls = new ArrayList<>();
                while (resultSet.next()) {
                    if (detailTour == null) {
                        int id = resultSet.getInt("IdTour");
                        String name = resultSet.getString("NameTour");
                        int price = resultSet.getInt("PriceTour");
                        String description = resultSet.getString("DescriptionTour");
                        int numberDay = resultSet.getInt("NumberDay");
                        String hotel = resultSet.getString("Hotel");
                        String vehicle = resultSet.getString("Vehicle");
                        boolean isFavorite = resultSet.getInt("IsFavorite") == 1;

                        detailTour = new DetailModel(id, name, isFavorite, price, description, numberDay, hotel, vehicle, imageUrls);
                    }
                    imageUrls.add(resultSet.getString("ImgResource"));
                }

                detailCallBack.onDetailTourLoaded(detailTour);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
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
