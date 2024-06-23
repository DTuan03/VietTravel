package com.httt1.vietnamtravel.home.model;

import android.util.Log;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;
    private final List<TourModel> favoriteTours;

    public HomeRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
        this.favoriteTours = new ArrayList<>();
    }

    public HomeRepository(SQLServerDataSource sqlServerDataSource) {
        this.sqlServerDataSource = sqlServerDataSource;
        this.executorService = Executors.newSingleThreadExecutor();
        this.favoriteTours = new ArrayList<>();
    }


    public void removeFavorite(int userId, String tourId) {
        executorService.execute(() -> {
            synchronized (favoriteTours) {
                // Tìm tour có tourId trong danh sách favoriteTours
                Optional<TourModel> optionalTour = favoriteTours.stream()
                        .filter(tour -> tour.getTourId().equals(tourId))
                        .findFirst();

                if (optionalTour.isPresent()) {
                    TourModel tour = optionalTour.get();
                    tour.setIsFavorite(false); // Đánh dấu tour là không yêu thích trước khi xóa
                    favoriteTours.removeIf(t -> t.getTourId().equals(tourId)); // Xóa tour khỏi danh sách favoriteTours

                    // Thực hiện xóa tour từ cơ sở dữ liệu
                    String query = "DELETE FROM favtour WHERE UserId = ? AND TourId = ?";
                    try (Connection connection = sqlServerDataSource.getConnection();
                         PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setInt(1, userId);
                        statement.setString(2, tourId);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected <= 0) {
                            // Nếu không xóa được từ cơ sở dữ liệu, thêm lại tour vào danh sách favoriteTours
                            favoriteTours.add(tour);
                            tour.setIsFavorite(true); // Đánh dấu lại tour là yêu thích
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Nếu xảy ra lỗi, thêm lại tour vào danh sách favoriteTours và đánh dấu lại là yêu thích
                        favoriteTours.add(tour);
                        tour.setIsFavorite(true);
                    }
                }
            }
        });
    }


    public void addFavorite(int userId, TourModel tour) {
        executorService.execute(() -> {
            synchronized (favoriteTours) {
                // Thực hiện thêm tour vào cơ sở dữ liệu
                String query = "INSERT INTO favtour (UserId, TourId, NameTour, PriceTour, ImgResource) VALUES (?, ?, ?, ?, ?)";
                try (Connection connection = sqlServerDataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, userId);
                    statement.setString(2, tour.getTourId());
                    statement.setString(3, tour.getNameTour());
                    statement.setInt(4, tour.getPrice());
                    statement.setString(5, tour.getUrlImg());
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        tour.setIsFavorite(true); // Đánh dấu tour là yêu thích
                        favoriteTours.add(tour); // Thêm vào danh sách yêu thích
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    // Callback interfaces
    public interface ComboCallBack {
        void listCombo(List<TourModel> listComboTour);
    }

    public interface DiscoverCallBack {
        void listDiscover(List<TourModel> listDiscover);
    }

    // Method to get combo tours
    public void getComboTour(int userId, ComboCallBack comboCallBack) {
        executorService.execute(() -> {
            String query = "SELECT Tour.TourId, Tour.TypeTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, " +
                    "CASE WHEN FavTour.UserId = ? THEN 1 ELSE 0 END AS IsFavorite " +
                    "FROM Tour " +
                    "INNER JOIN ImgTour ON Tour.TourId = ImgTour.TourId " +
                    "LEFT JOIN FavTour ON Tour.TourId = FavTour.TourId AND FavTour.UserId = ? " +
                    "WHERE ImgTour.ImgPosition = 1 AND Tour.TypeTour = 'CB'";
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, userId);
                ResultSet resultSet = statement.executeQuery();
                List<TourModel> list = setDataCombo(resultSet);
                comboCallBack.listCombo(list);
                Log.d("So luong tour: ", "So luong tour yeu thich: " + list.size());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private List<TourModel> setDataCombo(ResultSet resultSet) throws SQLException {
        List<TourModel> combos = new ArrayList<>();
        while (resultSet.next()) {
            String tourId = resultSet.getString("TourId");
            String nameTour = resultSet.getString("NameTour");
            int priceTour = resultSet.getInt("PriceTour");
            String imgUrl = resultSet.getString("ImgResource");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Chuyển đổi giá trị isFavorite từ int sang boolean
            boolean favorite = isFavorite != 0;

            TourModel combo = new TourModel(tourId, imgUrl, nameTour, priceTour, favorite);
            combos.add(combo);
        }
        return combos;
    }


    // Method to get discover tours
    public void getDiscover(int userId, String typeDiscover, DiscoverCallBack discoverCallBack) {
        executorService.execute(() -> {
            String query;
            if (typeDiscover.equals("recommend")) {
                query = "SELECT Tour.TourId, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, ROUND(AVG(CAST(Feedback.Rating AS FLOAT)), 1) AS AvgRating, " +
                        "CASE WHEN FavTour.UserId = ? THEN 1 ELSE 0 END AS IsFavorite " +
                        "FROM Tour " +
                        "INNER JOIN ImgTour ON Tour.TourId = ImgTour.TourId " +
                        "INNER JOIN BookedTour ON Tour.TourId = BookedTour.TourId " +
                        "INNER JOIN Feedback ON Feedback.BookedTourId = BookedTour.BookedTourId " +
                        "LEFT JOIN FavTour ON Tour.TourId = FavTour.TourId AND FavTour.UserId = ? " +
                        "WHERE ImgTour.ImgPosition = 1 AND Tour.Recommend = 1 " +
                        "GROUP BY Tour.TourId, Tour.NameTour, ImgTour.ImgResource, Tour.PriceTour, FavTour.UserId";
            } else {
                query = "SELECT Tour.TourId, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, ROUND(AVG(CAST(Feedback.Rating AS FLOAT)), 1) AS AvgRating, " +
                        "CASE WHEN FavTour.UserId = ? THEN 1 ELSE 0 END AS IsFavorite " +
                        "FROM Tour " +
                        "INNER JOIN ImgTour ON Tour.TourId = ImgTour.TourId " +
                        "INNER JOIN BookedTour ON Tour.TourId = BookedTour.TourId " +
                        "INNER JOIN Feedback ON Feedback.BookedTourId = BookedTour.BookedTourId " +
                        "LEFT JOIN FavTour ON Tour.TourId = FavTour.TourId AND FavTour.UserId = ? " +
                        "WHERE ImgTour.ImgPosition = 1 AND Tour.NotMissed = 1 " +
                        "GROUP BY Tour.TourId, Tour.NameTour, ImgTour.ImgResource, Tour.PriceTour, FavTour.UserId";
            }
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, userId);
                ResultSet resultSet = statement.executeQuery();
                List<TourModel> discovers = setListDiscover(resultSet);
                discoverCallBack.listDiscover(discovers);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private List<TourModel> setListDiscover(ResultSet resultSet) throws SQLException {
        List<TourModel> discovers = new ArrayList<>();
        while (resultSet.next()) {
            String tourId = resultSet.getString("TourId");
            String nameTour = resultSet.getString("NameTour");
            String imgUrl = resultSet.getString("ImgResource");
            int price = resultSet.getInt("PriceTour");
            float avgRating = resultSet.getFloat("AvgRating");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Chuyển đổi giá trị isFavorite từ int sang boolean
            boolean favorite = isFavorite != 0;

            TourModel discover = new TourModel(tourId, imgUrl, nameTour, price, favorite);
            discovers.add(discover);
        }
        return discovers;
    }


}

