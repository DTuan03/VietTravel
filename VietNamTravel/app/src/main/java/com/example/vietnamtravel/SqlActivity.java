package com.example.vietnamtravel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vietnamtravel.Connection.SQL.ConnectSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SqlActivity extends AppCompatActivity {

    Connection con;
    String str;
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sql);


        txt = findViewById(R.id.name);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });
    }
    public void connect(){
        //Khởi tạo ExecutorService thực hiện tác vụ riêng kooong liên quan tới UI
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //Thực hiện tác vụ
        executorService.execute(() -> {
            try {
                con = ConnectSQL.CONN();
                if (con == null) {
                    str = "ERROR";
                } else {
                    // Truy vấn giá trị Name từ bảng Tour
                    Statement stmt = con.createStatement();
                    String query = "SELECT Name FROM Tour";
                    ResultSet rs = stmt.executeQuery(query);  //lặp qua tất cả
                    StringBuilder names = new StringBuilder(); // chứa mỗi chuỗi trên 1 dòng
                    while (rs.next()) {
                        names.append(rs.getString("Name")).append("\n");
                    }
                    rs.close();
                    stmt.close();
                    str = names.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                str = "DEFAULT";
            }
            //Cập nhật giao diện người dùng
            runOnUiThread(() -> {
                Toast.makeText(SqlActivity.this, str, Toast.LENGTH_SHORT).show();
                txt.setText(str);
            });
        });
    }

}