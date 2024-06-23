package com.httt.viettravel.TabHistory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Presenter.ReviewContract;
import com.httt.viettravel.Presenter.ReviewPresenter;
import com.httt.viettravel.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewActivity extends AppCompatActivity implements ReviewContract.View{

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int PICK_IMAGE_REQUEST_CODE = 200;
    private static final int REQUEST_PERMISSIONS_CODE = 123;

    private ImageView imageViewTour, btn_back;
    private TextView txtnameTour, txtnumberDay, txtTotal;
    private RatingBar ratingBar;
    private Button btn_submit, btn_selectPhoto;
    private EditText textViewComment;
    private RecyclerView recyclerViewPhotos;
    private ImageAdapter imageAdapter;
    private List<String> imageUris;
    private ReviewPresenter presenter;
    private String idBookedTour;
    private String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review);

        initViews();
        presenter = new ReviewPresenter(this);
        presenter.checkPermissions(this); // Check permissions on start

        btn_submit.setOnClickListener(v -> {
            int rating = (int) ratingBar.getRating();
            String comment = textViewComment.getText().toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String currentDate = dateFormat.format(new Date());
            String currentTime = timeFormat.format(new Date());

            presenter.submitFeedback(idBookedTour, comment, rating, currentDate, currentTime, imageUris);
        });

        btn_back.setOnClickListener(v -> finish());

        btn_selectPhoto.setOnClickListener(v -> presenter.openImagePicker(this));
    }

    private void initViews() {
        ratingBar = findViewById(R.id.ratingBar_review);
        btn_submit = findViewById(R.id.btn_submit_review);
        btn_back = findViewById(R.id.btn_back_review);
        btn_selectPhoto = findViewById(R.id.selectPhoto_review);
        imageViewTour = findViewById(R.id.imageView_review);
        txtnameTour = findViewById(R.id.nameTour_review);
        txtnumberDay = findViewById(R.id.NumberDay_review);
        txtTotal = findViewById(R.id.total_review);
        textViewComment = findViewById(R.id.txtRate_review);
        recyclerViewPhotos = findViewById(R.id.recyclerViewPhotos_review);

        imageUris = new ArrayList<>();
        imageAdapter = new ImageAdapter(this, imageUris);
        recyclerViewPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPhotos.setAdapter(imageAdapter);

        // Nhận dữ liệu từ Intent
        idBookedTour = getIntent().getStringExtra("idBookedTour");
        txtnameTour.setText(getIntent().getStringExtra("nameTour"));
        txtnumberDay.setText(String.valueOf(getIntent().getIntExtra("numberDay", 0)));
        txtTotal.setText(String.valueOf(getIntent().getFloatExtra("total", 0)));
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.handleActivityResult(requestCode, resultCode, data, this, imageUris, currentPhotoPath);
    }

    @Override
    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        // Gửi broadcast để cập nhật giao diện ở cả Tab1 và Tab2
        Intent intent = new Intent("com.httt.viettravel.REVIEW_SAVED");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
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
        this.imageUris = imageUris;
        imageAdapter.updateImages(imageUris);
    }
}
