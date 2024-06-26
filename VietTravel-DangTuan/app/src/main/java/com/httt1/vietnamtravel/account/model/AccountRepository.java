package com.httt1.vietnamtravel.account.model;

import com.httt1.vietnamtravel.common.database.SQLServerDataSource;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountRepository {
    private final SQLServerDataSource sqlServerDataSource;
    private final ExecutorService executorService;

    public AccountRepository() {
        this.sqlServerDataSource = new SQLServerDataSource();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public interface InfoUserCallBack{
        void infoUser(AccountModel accountModel);
    }

    public void getInfoUser(int userId, InfoUserCallBack infoUserCallBack){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "SELECT UserName, UserPhone, UserBirth, UserEmail, UserAddress, UserImg FROM Users WHERE UserId = ?";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);
                        ){
                    statement.setInt(1, userId);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()){
                        String userName = resultSet.getString(1);
                        String userPhone = resultSet.getString(2);
                        String userBirth = resultSet.getString(3);
                        String userEmail = resultSet.getString(4);
                        String userAddress = resultSet.getString(5);
                        AccountModel accountModel = new AccountModel(userName, userPhone, userBirth, userEmail, userAddress);
                        infoUserCallBack.infoUser(accountModel);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateAccount(String properties, String value, int userid){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String query = "UPDATE Users SET " + properties + " = ? WHERE UserId = ?";
                try(
                        Connection connection = sqlServerDataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);
                        ){
                    statement.setString(1,value);
                    statement.setInt(2, userid);
                    statement.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
