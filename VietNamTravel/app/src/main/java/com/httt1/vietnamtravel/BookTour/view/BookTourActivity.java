package com.httt1.vietnamtravel.BookTour.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.httt1.vietnamtravel.BookTour.model.BookTourRepository;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.squareup.picasso.Picasso;
import com.httt1.vietnamtravel.R;

public class BookTourActivity extends AppCompatActivity {

    private ImageView imgTour;
    private TextView tvTitle, tvPrice;
    private EditText etUserName, etPhoneNumber, etEmail;
    private Button btnBookTour;
    private int userId, tourId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tour);

        // Initialize views
        imgTour = findViewById(R.id.activity_book_tour_img);
        tvTitle = findViewById(R.id.activity_book_tour_tv_title);
        tvPrice = findViewById(R.id.activity_book_tour_tv_price);
        etUserName = findViewById(R.id.activity_book_tour_et_username);
        etPhoneNumber = findViewById(R.id.activity_book_tour_et_phonenumber);
        etEmail = findViewById(R.id.activity_book_tour_et_email);
        btnBookTour = findViewById(R.id.activity_book_tour_btn_booking);

        // Receive data from intent
        userId = getIntent().getIntExtra("userId", 0);
        tourId = getIntent().getIntExtra("tourId", 0);

        // Load tour details based on tourId
        loadTourDetails(tourId);

    }

    private void loadTourDetails(int tourId) {
        BookTourRepository bookTourRepository = new BookTourRepository();
        bookTourRepository.getBookTour(userId, tourId, new BookTourRepository.BookTourCallBack() {
            @Override
            public void onBookTourLoaded(HomeModel bookTour) {
                if (bookTour != null) {
                    // Set tour details to views
                    tvTitle.setText(bookTour.getNameTour());
                    tvPrice.setText(bookTour.getPrice());

                    // Load image using Picasso or Glide
                    String imageUrl = bookTour.getUrlImg(); // Assuming you have a method to get image URL
                    Picasso.get().load(imageUrl).into(imgTour);
                }
            }
        });
    }
}
