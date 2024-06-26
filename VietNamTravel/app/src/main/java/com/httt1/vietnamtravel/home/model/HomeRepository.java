package com.httt1.vietnamtravel.home.model;

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

public  class HomeRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public HomeRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public HomeRepository(SQLServerDataSource sqlServerDataSource) {
        this.sqlServerDataSource = sqlServerDataSource;
        this.executorService = Executors.newSingleThreadExecutor();
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

    // Callback interfaces
    public interface ComboCallBack {
        void listCombo(List<HomeModel> listComboTour);
    }

    // Method to get combo tours
    public void getComboTour(int userId, ComboCallBack comboCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Tour.IdTour, Tour.TypeTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource, " +
                        "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite " +
                        "FROM Tour " +
                        "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                        "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour AND FavTour.IdUser = ? " +
                        "WHERE ImgTour.ImgPosition = 1 AND Tour.TypeTour = 'CB'";
                try (Connection connection = sqlServerDataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    List<HomeModel> list = setDataCombo(resultSet);
                    comboCallBack.listCombo(list);
                    Log.d("So luong tour: ", "So luong tour yeu thich: " + list.size());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private List<HomeModel> setDataCombo(ResultSet resultSet) throws SQLException{
        List<HomeModel> combos = new ArrayList<>();
        while (resultSet.next()){
            int tourId = resultSet.getInt("IdTour");
            String nameTour = resultSet.getString("NameTour");
            int price = resultSet.getInt("PriceTour");
            String imgUrl = resultSet.getString("ImgResource");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Chuyển đổi giá trị isFavorite từ int sang boolean
            boolean favorite = isFavorite != 0;

            HomeModel combo = new HomeModel(tourId, imgUrl, nameTour, price, favorite);
            combos.add(combo);
        }
        return combos;
    }

    public interface VoucherCallBack{
        void listVoucher(List<HomeModel> listVoucher);
    }
    public void getVoucher(VoucherCallBack voucherCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Voucher.IdVoucher, ImgVoucher.ImgResoucre " +
                        "FROM Voucher INNER JOIN ImgVoucher " +
                        "ON Voucher.IdVoucher = ImgVoucher.IdVoucher ";
                try (Connection connection = sqlServerDataSource.getConnection();
                     PreparedStatement statement = connection.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {

                    List<HomeModel> vouchers = setListVoucher(resultSet);
                    voucherCallBack.listVoucher(vouchers);
                    Log.d("So luong Voucher", "So luong la: " + vouchers.size());
                } catch (SQLException e) {
                    e.printStackTrace();
                    voucherCallBack.listVoucher(new ArrayList<>());
                }
            }
        });
    }

    private List<HomeModel> setListVoucher(ResultSet resultSet) throws SQLException {
        List<HomeModel> vouchers = new ArrayList<>();
        while (resultSet.next()) {
            int voucherId = resultSet.getInt("IdVoucher");
            String imgUrl = resultSet.getString("ImgResource");
            HomeModel voucher = new HomeModel(voucherId, imgUrl);
            vouchers.add(voucher);
        }
        return vouchers;
    }


    public interface CheckMyVoucherCallBack{
        void checkMyVoucher(boolean checkMyVoucher);
    }

    public void getMyVoucher(int userId, int voucherId, CheckMyVoucherCallBack checkMyVoucherCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Voucher.IdVoucher " +
                        "FROM Voucher " +
                        "INNER JOIN ImgVoucher ON Voucher.IdVoucher = ImgVoucher.IdVoucher " +
                        "INNER JOIN MyVoucher ON Voucher.IdVoucher = MyVoucher.IdVoucher " +
                        "WHERE Voucher.IdVoucher = ? AND MyVoucher.IdUser = ? ";
                try (
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);
                ){
                    statement.setInt(1, voucherId);
                    statement.setInt(2, userId);
                    ResultSet resultSet = statement.executeQuery();
                    // co dong dau tien thi tra ve true
                    checkMyVoucherCallBack.checkMyVoucher(resultSet.next()); // da luu
                    Log.d("vOUCHER", "vOUCHERiD" + voucherId);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void saveVoucher(int userId, int voucherId){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "INSERT INTO MyVoucher(IdUser, IdVoucher) VALUES (?, ?) ";

                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);
                ){
                    statement.setInt(1, userId);
                    statement.setInt(2, voucherId);
                    int rowsInserted = statement.executeUpdate();
//                        if (rowsInserted > 0) {
//                            System.out.println("Voucher đã được lưu thành công!");
//                        } else {
//                            System.out.println("Lưu voucher không thành công.");
//                        }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public interface DiscoverCallBack {
        void listDiscover(List<HomeModel> listDiscover);
    }

    // Method to get discover tours
    public void getDiscover(int userId, String typeDiscover, DiscoverCallBack discoverCallBack) {
        executorService.execute(() -> {
            String query = "";
            if (typeDiscover.equals("recommend")) {
                query = "SELECT Tour.IdTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource " +
                        "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite " +
                        "FROM Tour " +
                        "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                        "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour AND FavTour.IdUser = ? " +
                        "WHERE ImgTour.ImgPosition = 1 AND Tour.Recommend = 1 " +
                        "GROUP BY Tour.IdTour, Tour.NameTour, ImgTour.ImgResource, Tour.PriceTour, FavTour.IdUser";
            } else if (typeDiscover.equals("notmissed")) {
                query = "SELECT Tour.IdTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource " +
                        "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite " +
                        "FROM Tour " +
                        "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                        "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour AND FavTour.IdUser = ? " +
                        "WHERE ImgTour.ImgPosition = 1 AND Tour.NotMissed = 1 " +
                        "GROUP BY Tour.IdTour, Tour.NameTour, ImgTour.ImgResource, Tour.PriceTour, FavTour.IdUser";
            } else if (typeDiscover.equals("favorite")) {
                query = "SELECT FavTour.IdUser, Tour.IdTour, Tour.NameTour, Tour.PriceTour, ImgTour.ImgResource," +
                        "CASE WHEN FavTour.IdUser IS NOT NULL THEN 1 ELSE 0 END AS IsFavorite" +
                        "FROM Tour" +
                        "INNER JOIN ImgTour ON Tour.IdTour = ImgTour.IdTour " +
                        "LEFT JOIN FavTour ON Tour.IdTour = FavTour.IdTour " +
                        "WHERE ImgTour.ImgPosition = 1 AND FavTour.IdUser IS NOT NULL " +
                        "GROUP BY Tour.IdTour, Tour.NameTour, ImgTour.ImgResource, Tour.PriceTour, FavTour.IdUser";
            }
            try (Connection connection = sqlServerDataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                ResultSet resultSet = statement.executeQuery();
                List<HomeModel> discovers = setListDiscover(resultSet);
                discoverCallBack.listDiscover(discovers);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private List<HomeModel> setListDiscover(ResultSet resultSet) throws SQLException {
        List<HomeModel> discovers = new ArrayList<>();
        while (resultSet.next()) {
            int tourId = resultSet.getInt("IdTour");
            String nameTour = resultSet.getString("NameTour");
            String imgUrl = resultSet.getString("ImgResource");
            int price = resultSet.getInt("PriceTour");
            float avgRating = resultSet.getFloat("AvgRating");
            int isFavorite = resultSet.getInt("IsFavorite");

            // Chuyển đổi giá trị isFavorite từ int sang boolean
            boolean favorite = isFavorite != 0;

            HomeModel discover = new HomeModel(tourId, imgUrl, nameTour, price, favorite);
            discovers.add(discover);
        }
        return discovers;
    }


}

