package com.httt.viettravel.TabHistory;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Presenter.ReviewContract;
import com.httt.viettravel.Presenter.ReviewPresenter;
import com.httt.viettravel.R;
import com.squareup.picasso.BuildConfig;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReviewActivity extends AppCompatActivity implements ReviewContract.View {

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
    private List<Uri> imageUris;
    private ReviewPresenter presenter;
    private String idBookedTour;
    private String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review);

        initViews();
        checkPermissions(); // Kiểm tra và yêu cầu quyền

        presenter = new ReviewPresenter(this);

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

        btn_selectPhoto.setOnClickListener(v -> openImagePicker());
    }

    private void initViews() {
        ratingBar = findViewById(R.id.ratingBar);
        btn_submit = findViewById(R.id.btn_submit);
        btn_back = findViewById(R.id.btn_back);
        btn_selectPhoto = findViewById(R.id.selectPhoto);
        imageViewTour = findViewById(R.id.imageView);
        txtnameTour = findViewById(R.id.nameTour);
        txtnumberDay = findViewById(R.id.NumberDay);
        txtTotal = findViewById(R.id.total);
        textViewComment = findViewById(R.id.txtRate);
        recyclerViewPhotos = findViewById(R.id.recyclerViewPhotos);

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

    private void checkPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };

        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[0]), REQUEST_PERMISSIONS_CODE);
        }
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
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
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri imageUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", new File(currentPhotoPath));
            imageUris.add(imageUri);
            imageAdapter.notifyDataSetChanged();
        } else if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();
                    for (int i = 0; i < count; i++) {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        imageUris.add(imageUri);
                    }
                } else if (data.getData() != null) {
                    Uri imageUri = data.getData();
                    imageUris.add(imageUri);
                }
                imageAdapter.notifyDataSetChanged();
            }
        }
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
}
