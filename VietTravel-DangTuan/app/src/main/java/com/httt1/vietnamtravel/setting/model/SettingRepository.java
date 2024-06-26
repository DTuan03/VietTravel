package com.httt1.vietnamtravel.setting.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;
    public SettingRepository(){
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface NameCallBack{
        void getNameUser(String nameUser);
    }

    public void getNameUser(int userId, NameCallBack nameCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT UserName FROM Users WHERE UserId = ? ";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);
                        ){
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    resultSet.next();
                    nameCallBack.getNameUser(resultSet.getString("UserName"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}
