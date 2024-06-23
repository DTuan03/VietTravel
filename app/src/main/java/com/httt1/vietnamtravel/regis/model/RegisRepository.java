package com.httt1.vietnamtravel.regis.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public RegisRepository(){
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface CheckUserCallBack{
        void onCheckUser(boolean success);
    }
    public void User(RegisModel user) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "INSERT INTO Users (Username, UserPhone, UserPass) VALUES (?, ?, ?)";
                try (
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query))
                {
                    statement.setString(1, user.getFullName());
                    statement.setString(2, user.getPhone());
                    statement.setString(3, user.getPass());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void CheckUser(String phone, CheckUserCallBack checkUser){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT UserPhone, UserPass FROM Users WHERE UserPhone = ?";
                try (
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query)
                ) {
                    statement.setString(1, phone);
                    ResultSet resultSet = statement.executeQuery();
                    checkUser.onCheckUser(resultSet.next());
                } catch (SQLException e) {
                    e.printStackTrace();
                    checkUser.onCheckUser(false);
                }
            }
        });
    }
}
