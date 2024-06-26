package com.httt1.vietnamtravel.bookTour.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookTourRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public BookTourRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface ListVouherCallBack{
        void getListVoucher(ArrayList<String> array);
    }

    public void getVoucher(int userId,int total, ListVouherCallBack listVouherCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Voucher.DescriptionVoucher FROM Voucher INNER JOIN MyVoucher ON Voucher.IdVoucher = MyVoucher.IdVoucher WHERE MyVoucher.IdUser = ? AND Voucher.Condition >= total";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query)
                ){
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    ArrayList<String> voucherList = new ArrayList<>();
                    while (resultSet.next()){
                        String DescriptionVoucher = resultSet.getString("DescriptionVoucher");
                        voucherList.add(DescriptionVoucher);
                    }
                    listVouherCallBack.getListVoucher(voucherList);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public interface IdVouherCallBack{
        void getVoucher(ArrayList<Integer> voucher);
    }

    public void getIdVoucher(String title, IdVouherCallBack idVouherCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Voucher.IdVoucher, Voucher.Discount FROM Voucher WHERE Voucher.TitleVoucher = ?";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query)
                ){
                    statement.setString(1, title);
                    ResultSet resultSet = statement.executeQuery();
                    ArrayList<Integer> voucher = new ArrayList<>();
                    while (resultSet.next()){
                        int idVoucher = resultSet.getInt("IdVoucher");
                        int discount = resultSet.getInt("Discount");
                        voucher.add(idVoucher);
                        voucher.add(discount);
                    }
                    idVouherCallBack.getVoucher(voucher);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
