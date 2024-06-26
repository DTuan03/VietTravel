package com.httt1.vietnamtravel.common.database;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerDataSource {

    private static final String connectionString = "jdbc:jtds:sqlserver://httt1nhom8.database.windows.net:1433;DatabaseName=VietNamTravel;user=httt1nhom8@httt1nhom8;password=Tuan12082003;ssl=require;sslfactory=org.tlstm.TLSv1";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Nạp driver Microsoft JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Log.d("SQLServerDataSource", "Driver loaded successfully");
            connection = DriverManager.getConnection(connectionString);
            Log.d("SQLServerDataSource", "Connection established successfully");
        } catch (SQLException e) {
            Log.e("SQLServerDataSource", "SQL Exception during connection", e);
            throw e; // Throwing SQLException for caller to handle
        } catch (ClassNotFoundException e) {
            Log.e("SQLServerDataSource", "Driver class not found", e);
            throw new RuntimeException(e);
        }

        return connection;
    }
}