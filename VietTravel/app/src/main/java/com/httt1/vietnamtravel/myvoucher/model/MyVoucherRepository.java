package com.httt1.vietnamtravel.myvoucher.model;

import android.util.Log;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.login.model.LoginModel;
import com.httt1.vietnamtravel.login.model.LoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyVoucherRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public MyVoucherRepository(){
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface MyVoucherCallBack{
        void getListMyVoucher(List<MyVoucherModel> listMyVoucher);
    }
    public void getMyVoucher(int userId, MyVoucherCallBack myVoucherCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT ImgVoucher.ImgResource, Voucher.TitleVoucher, Voucher.DescriptionVoucher " +
                        "FROM Voucher INNER JOIN ImgVoucher " +
                        "ON Voucher.IdVoucher = ImgVoucher.IdVoucher " +
                        "INNER JOIN MyVoucher ON Voucher.IdVoucher = MyVoucher.IdVoucher " +
                        "WHERE MyVoucher.IdUser = ?";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);
                ){
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    List<MyVoucherModel> list = setDataMyVoucher(resultSet);
                    Log.d("Danh sach Voucher", "La : " + list.size());
                    myVoucherCallBack.getListMyVoucher(list);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });
    }

    private List<MyVoucherModel> setDataMyVoucher(ResultSet resultSet) throws SQLException{
        List<MyVoucherModel> myVouchers = new ArrayList<>();
        while (resultSet.next()){
            String imgUrl = resultSet.getString("ImgResource");
            String title = resultSet.getString("TitleVoucher");
            String descriptionVoucher = resultSet.getString("DescriptionVoucher");
            MyVoucherModel myVoucher = new MyVoucherModel(imgUrl, title, descriptionVoucher);
            myVouchers.add(myVoucher);
        }
        return myVouchers;
    }
}
