package com.example.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FeedbackActivity extends AppCompatActivity {
    private ImageView imageViewTour;
    TextView textViewContent, textViewLocation, textViewRoutine, textViewTime, textViewPrice, textViewVehicle, textViewPlace;
    RatingBar ratingBar;
    Button btn_submit ;
    TextView tvRatingMessage;
    EditText textViewComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback);

        ratingBar = findViewById(R.id.ratingBar);
        btn_submit =findViewById(R.id.btn_submit);

        tvRatingMessage = findViewById(R.id.tvRatingMessage);



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
            String comment = intent.getStringExtra("comment");

            // Hiển thị dữ liệu lên các views
            imageViewTour.setImageResource(pic);
            textViewContent.setText(content);
            textViewLocation.setText(location);
            textViewRoutine.setText(routine);
            textViewTime.setText(time);
            textViewPrice.setText(price);
            textViewVehicle.setText(vehicle);
            textViewPlace.setText(place);
            textViewComment.setText(comment);


        btn_submit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String cmt = String.valueOf(textViewComment.getText());
            String message = "Bạn đã đánh giá " + rating + " sao.\n"+ cmt ;
            tvRatingMessage.setText(message);
        });
    }
}