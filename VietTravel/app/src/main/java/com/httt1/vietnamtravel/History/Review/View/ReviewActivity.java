package com.httt1.vietnamtravel.History.Review.View;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.History.Rated.Adapter.ImageAdapter;
import com.httt1.vietnamtravel.History.Review.Presenter.ReviewContract;
import com.httt1.vietnamtravel.History.Review.Presenter.ReviewPresenter;
import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewActivity extends AppCompatActivity implements ReviewContract.View {

    private static final int PICK_IMAGE_REQUEST_CODE = 200;

    private ImageView btn_back;
    private TextView txtnameTour, txtnumberDay, txtTotal;
    private RatingBar ratingBar;
    private Button btn_submit, btn_selectPhoto;
    private EditText textViewComment;
    private RecyclerView recyclerViewPhotos;
    private ImageAdapter imageAdapter;
    private List<String> imageUris;
    private ReviewPresenter presenter;
    private String idBookedTour;
    private int userId; // Fixed user ID

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); // Use 'this' for Activity context
        userId = sharedPrefsHelper.getInt("UserId"); // Retrieve user ID from SharedPreferences

        initViews();
        presenter = new ReviewPresenter(this, this); // Pass activity context to presenter

        btn_submit.setOnClickListener(v -> {
            int rating = (int) ratingBar.getRating();
            String comment = textViewComment.getText().toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String currentDate = dateFormat.format(new Date());
            String currentTime = timeFormat.format(new Date());

            presenter.submitFeedback(String.valueOf(userId), idBookedTour, comment, rating, currentDate, currentTime, imageUris);
        });

        btn_back.setOnClickListener(v -> finish());

        btn_selectPhoto.setOnClickListener(v -> presenter.openImagePicker(this));
    }

    private void initViews() {
        imageView = findViewById(R.id.imageView_review);
        ratingBar = findViewById(R.id.ratingBar_review);
        btn_submit = findViewById(R.id.btn_submit_review);
        btn_back = findViewById(R.id.btn_back_review);
        btn_selectPhoto = findViewById(R.id.selectPhoto_review);
        txtnameTour = findViewById(R.id.nameTour_review);
        txtnumberDay = findViewById(R.id.NumberDay_review);
        txtTotal = findViewById(R.id.total_review);
        textViewComment = findViewById(R.id.txtRate_review);
        recyclerViewPhotos = findViewById(R.id.recyclerViewPhotos_review);

        imageUris = new ArrayList<>();
        imageAdapter = new ImageAdapter(this, imageUris);
        recyclerViewPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPhotos.setAdapter(imageAdapter);

        // Receive data from Intent
        String imgMainResource = getIntent().getStringExtra("imgMainResource");
        idBookedTour = getIntent().getStringExtra("idBookedTour");
        txtnameTour.setText(getIntent().getStringExtra("nameTour"));
        txtnumberDay.setText(String.valueOf(getIntent().getIntExtra("numberDay", 0)));
        txtTotal.setText(String.valueOf(getIntent().getIntExtra("total", 0)));

        Picasso.get().load(imgMainResource).into(imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_IMAGE_REQUEST_CODE) {
                if (data != null) {
                    if (data.getClipData() != null) {
                        int count = data.getClipData().getItemCount();
                        for (int i = 0; i < count; i++) {
                            Uri imageUri = data.getClipData().getItemAt(i).getUri();
                            imageUris.add(imageUri.toString());
                        }
                    } else if (data.getData() != null) {
                        Uri imageUri = data.getData();
                        imageUris.add(imageUri.toString());
                    }
                    imageAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        // Send a Local Broadcast to update the UI of fragments
        Intent intent = new Intent("com.httt.viettravel.ACTION_REVIEW_SUBMITTED");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        navigateBack();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateBack() {
        finish();
    }

    @Override
    public void updateImageList(List<String> imageUris) {
        this.imageUris.clear();
        this.imageUris.addAll(imageUris);
        imageAdapter.notifyDataSetChanged();
    }
}
