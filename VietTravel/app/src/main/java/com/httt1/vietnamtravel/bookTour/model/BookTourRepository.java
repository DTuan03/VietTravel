package com.httt1.vietnamtravel.bookTour.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
        String[] getListVoucher(String[] array);
    }

    private void getVoucher(int userId, ListVouherCallBack listVouherCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT Voucher.DescriptionVoucher FROM Voucher INNER JOIN MyVoucher ON Voucher.IdVoucher = MyVoucher.IdVoucher WHERE MyVoucher.IdUser = ?";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query)
                ){
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    ArrayList<String> voucherList = new ArrayList<>();
//                    listVouherCallBack.getListVoucher(array);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
