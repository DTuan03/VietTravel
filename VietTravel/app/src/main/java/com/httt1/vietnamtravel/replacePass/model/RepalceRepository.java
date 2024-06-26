package com.httt1.vietnamtravel.replacePass.model;

import android.util.Log;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.regis.model.RegisModel;
import com.httt1.vietnamtravel.regis.model.RegisRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RepalceRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public RepalceRepository(){
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void updatePass(String pass, int userId) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "UPDATE Users SET UserPass = ? WHERE IdUser = ?";
                try (
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query))
                {
                    statement.setString(1, pass);
                    statement.setInt(2, userId);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public interface CheckPassOldCallBack{
        void onCheckPassOld(String pass);
    }

    public void CheckPass(int userId, CheckPassOldCallBack checkPassOldCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT UserPass FROM Users WHERE IdUser = ?";
                try (
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query)
                ) {
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    String pass = null;
                    if (resultSet.next()) {
                        pass = resultSet.getString("UserPass");
                    }
                    checkPassOldCallBack.onCheckPassOld(pass);
                    Log.d("Pass", "Pass la: " + pass);
                } catch (SQLException e) {
                    e.printStackTrace();
                    checkPassOldCallBack.onCheckPassOld(null);
                }
            }
        });
    }
}
