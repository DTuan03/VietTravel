package com.httt1.vietnamtravel.AllTours.model;

import android.util.Log;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.home.model.TourModel;

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
//    private final List<TourModel> favoriteTours;

    public AllTourRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
//        this.favoriteTours = new ArrayList<>();
    }

    public AllTourRepository(SQLServerDataSource sqlServerDataSource) {
        this.sqlServerDataSource = sqlServerDataSource;
        this.executorService = Executors.newSingleThreadExecutor();
//        this.favoriteTours = new ArrayList<>();
    }


//    public void removeFavorite(int userId, String tourId) {
//        executorService.execute(() -> {
//            synchronized (favoriteTours) {
//                // Tìm tour có tourId trong danh sách favoriteTours
//                Optional<TourModel> optionalTour = favoriteTours.stream()
//                        .filter(tour -> tour.getTourId().equals(tourId))
//                        .findFirst();
//
//                if (optionalTour.isPresent()) {
//                    TourModel tour = optionalTour.get();
//                    tour.setIsFavorite(false); // Đánh dấu tour là không yêu thích trước khi xóa
//                    favoriteTours.removeIf(t -> t.getTourId().equals(tourId)); // Xóa tour khỏi danh sách favoriteTours
//
//                    // Thực hiện xóa tour từ cơ sở dữ liệu
//                    String query = "DELETE FROM favtour WHERE UserId = ? AND TourId = ?";
//                    try (Connection connection = sqlServerDataSource.getConnection();
//                         PreparedStatement statement = connection.prepareStatement(query)) {
//                        statement.setInt(1, userId);
//                        statement.setString(2, tourId);
//                        int rowsAffected = statement.executeUpdate();
//                        if (rowsAffected <= 0) {
//                            // Nếu không xóa được từ cơ sở dữ liệu, thêm lại tour vào danh sách favoriteTours
//                            favoriteTours.add(tour);
//                            tour.setIsFavorite(true); // Đánh dấu lại tour là yêu thích
//                        }
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                        // Nếu xảy ra lỗi, thêm lại tour vào danh sách favoriteTours và đánh dấu lại là yêu thích
//                        favoriteTours.add(tour);
//                        tour.setIsFavorite(true);
//                    }
//                }
//            }
//        });
//    }


//    public void addFavorite(int userId, TourModel tour) {
//        executorService.execute(() -> {
//            synchronized (favoriteTours) {
//                // Thực hiện thêm tour vào cơ sở dữ liệu
//                String query = "INSERT INTO favtour (UserId, TourId, NameTour, PriceTour, ImgResource) VALUES (?, ?, ?, ?, ?)";
//                try (Connection connection = sqlServerDataSource.getConnection();
//                     PreparedStatement statement = connection.prepareStatement(query)) {
//                    statement.setInt(1, userId);
//                    statement.setString(2, tour.getTourId());
//                    statement.setString(3, tour.getNameTour());
//                    statement.setInt(4, tour.getPrice());
//                    statement.setString(5, tour.getUrlImg());
//                    int rowsAffected = statement.executeUpdate();
//                    if (rowsAffected > 0) {
//                        tour.setIsFavorite(true); // Đánh dấu tour là yêu thích
//                        favoriteTours.add(tour); // Thêm vào danh sách yêu thích
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }


    // Callback interfaces
    public interface AllTourCallBack {
        void listAllTour(List<TourModel> listAllTour);
    }

    // Method to get all tours
    public void getAllTour(int userId, AllTourRepository.AllTourCallBack allTourCallBack) {
        executorService.execute(() -> {
            String query = "SELECT Tour.TourId, Tour.TypeTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, " +
                    "CASE WHEN FavTour.UserId = ? THEN 1 ELSE 0 END AS IsFavorite " +
                    "FROM Tour " +
                    "INNER JOIN ImgTour ON Tour.TourId = ImgTour.TourId " +
                    "LEFT JOIN FavTour ON Tour.TourId = FavTour.TourId AND FavTour.UserId = ? ";
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setInt(2, userId);
                ResultSet resultSet = statement.executeQuery();
                List<TourModel> list = setDataAllTour(resultSet);
                allTourCallBack.listAllTour(list);
                Log.d("So luong tour: ", "So luong tour yeu thich: " + list.size());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private List<TourModel> setDataAllTour(ResultSet resultSet) throws SQLException {
        List<TourModel> alltours = new ArrayList<>();
        while (resultSet.next()) {
            String tourId = resultSet.getString("TourId");
            String nameTour = resultSet.getString("NameTour");
            int priceTour = resultSet.getInt("PriceTour");
            String imgUrl = resultSet.getString("ImgResource");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Chuyển đổi giá trị isFavorite từ int sang boolean
            boolean favorite = isFavorite != 0;

            TourModel alltour = new TourModel(tourId, imgUrl, nameTour, priceTour, favorite);
            alltours.add(alltour);
        }
        return alltours;
    }

}
