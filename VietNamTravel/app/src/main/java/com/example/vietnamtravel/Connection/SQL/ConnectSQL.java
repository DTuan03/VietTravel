package com.example.vietnamtravel.Connection.SQL;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {
    static String classes = "net.sourceforge.jtds.jdbc.Driver";

    protected static String ip = "192.168.1.118";
    protected static String port = "1433";
    protected static String db = "VIETNAMTRAVEL";
    protected static String un = "sa";
    protected static String password = "kt123";

    public static Connection CONN(){
        // Xin full quyền
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        try {
            Class.forName(classes);
            String conUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + un + ";password=" + password;
            conn = DriverManager.getConnection(conUrl, un, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
