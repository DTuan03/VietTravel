package com.httt.viettravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.httt.viettravel.Model.ImgTour;
import com.squareup.picasso.Picasso;

import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlActivity extends AppCompatActivity {
    private Button btnConnect;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sql);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                getImgFireBase("ImgTour/CBBTTV/2.jpeg");
            }
        });
    }

    private void init(){
        btnConnect = findViewById(R.id.sql_activity_btn_connect);
        imageView = findViewById(R.id.activity_sql_img);
    }

    //ham ket noi csdl
    private Connection connection(){
        Connection connection = null;
        try {
            //Muc dich de lay tat ca cac quyen ket noi
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); // thiet lap chinh sach ket noi bao gom tat ca cac quyen
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String connectString = "jdbc:jtds:sqlserver://192.168.1.9:1433;databasename=viettravel;user=sa;password=Tuan12082003@";
            connection = DriverManager.getConnection(connectString);
            Log.i("THONG BAO", "KET NOI THANH CONG VOI SQLSERVER");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void getData(){
        String prod = null, des = null;
        try {
            Connection connection = connection();
            if (connection !=null){
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Tour");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    prod = resultSet.getString(1);
                    des = resultSet.getString(2);
                    Log.i("Du lieu", prod+ "-" + des);
                }
                preparedStatement.close();
                Toast.makeText(getApplicationContext(), "Da thuc thu query", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), prod + "---" + des, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Trong phương thức getImgFireBase():
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    private void getImgFireBase(String link) {
        StorageReference imageRef = storageRef.child(link); // Đường dẫn ảnh trong Firebase Storage

        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Sử dụng Picasso để tải và hiển thị ảnh từ Firebase Storage vào ImageView
                Picasso.with(SqlActivity.this).load(uri).into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Xử lý trường hợp không thể tải xuống ảnh
                Log.e("Firebase", "Failed to download image: " + e.getMessage());
            }
        });
    }
}