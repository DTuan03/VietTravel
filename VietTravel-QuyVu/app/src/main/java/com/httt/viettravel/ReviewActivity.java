package com.httt.viettravel;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.TabHistory.Tab1;
import com.httt.viettravel.TabHistory.Tab2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ReviewActivity extends AppCompatActivity {

    private ImageView imageViewTour, btn_back;
    TextView textViewContent, textViewLocation, textViewRoutine, textViewTime, textViewPrice, textViewVehicle, textViewPlace;
    RatingBar ratingBar;
    Button btn_submit;
    EditText textViewComment;
    Fragment Tab1;
    private Tour tour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review);


        ratingBar = findViewById(R.id.ratingBar);
        btn_submit = findViewById(R.id.btn_submit);
        btn_back = findViewById(R.id.btn_back);


        // Khởi tạo các views
        imageViewTour = findViewById(R.id.imageView);
        textViewContent = findViewById(R.id.textViewContent);
        textViewLocation = findViewById(R.id.textViewLocation);
        textViewRoutine = findViewById(R.id.textViewRoutine);
        textViewTime = findViewById(R.id.textViewTime);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewVehicle = findViewById(R.id.textViewVehicle);
        textViewPlace = findViewById(R.id.textViewPlace);
        textViewComment = findViewById(R.id.textViewComment);


        tour = getIntent().getParcelableExtra("tour");
        // Lấy dữ liệu từ Intent
        Intent intent = getIntent();
        int pic = intent.getIntExtra("pic", 0);
        String content = intent.getStringExtra("content");
        String location = intent.getStringExtra("location");
        String routine = intent.getStringExtra("routine");
        String time = intent.getStringExtra("time");
        String price = intent.getStringExtra("price");
        String vehicle = intent.getStringExtra("vehicle");
        String place = intent.getStringExtra("place");
//        String comment = intent.getStringExtra("comment");

        // Hiển thị dữ liệu lên các views
        imageViewTour.setImageResource(pic);
        textViewContent.setText(content);
        textViewLocation.setText(location);
        textViewRoutine.setText(routine);
        textViewTime.setText(time);
        textViewPrice.setText(price);
        textViewVehicle.setText(vehicle);
        textViewPlace.setText(place);
//        textViewComment.setText(comment);


        btn_submit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String cmt = textViewComment.getText().toString();
            String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

            Toast.makeText(ReviewActivity.this, "Đánh giá đã được gửi thành công", Toast.LENGTH_SHORT).show();

            // Cập nhật thông tin đánh giá vào tour
            tour.setRating(rating);
            tour.setComment(cmt);
            tour.setDate(currentDate);
            tour.setTime(currentTime);
            // Truyền dữ liệu đánh giá về lại cho Tab1Fragment
            Intent resultIntent = new Intent();
            resultIntent.putExtra("updatedTour", tour);
            setResult(RESULT_OK, resultIntent);
            finish();
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sử dụng FragmentManager để quản lý Fragment trong Activity
                FragmentManager fragmentManager = getSupportFragmentManager(); // hoặc getFragmentManager() nếu bạn không sử dụng AppCompatActivity
                // Tạo một instance của Fragment bạn muốn hiển thị trong TabLayout1
                Tab1 = new Tab1();
                // Thực hiện việc thay đổi Fragment cho TabLayout1
                fragmentManager.beginTransaction().replace(R.id.tab1, Tab1).commit();
            }
        });
    }
}
