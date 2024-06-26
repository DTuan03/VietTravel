package com.httt1.vietnamtravel.History.Review.Presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.httt1.vietnamtravel.common.database.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class ReviewPresenter implements ReviewContract.Presenter {

    private ReviewContract.View view;
    private static final int PICK_IMAGE_REQUEST_CODE = 200;
    private static final int REQUEST_PERMISSIONS_CODE = 123;
    private String idBookedTour;
    private String userId;

    private static final Logger logger = Logger.getLogger(ReviewPresenter.class.getName());

    public ReviewPresenter(ReviewContract.View view) {
        this.view = view;
    }

    @Override
    public void submitFeedback(String userId, String idBookedTour, String comment, int rating, String date, String time, List<String> imageUris) {
        this.idBookedTour = idBookedTour;
        this.userId = userId;

        // Upload images to Firebase and save URLs to the database
        uploadImagesToFirebase(imageUris, new FirebaseUploadCallback() {
            @Override
            public void onUploadSuccess(List<String> firebaseImageUrls) {
                new SaveFeedbackTask(userId, idBookedTour, comment, rating, date, time, firebaseImageUrls).execute();
            }

            @Override
            public void onUploadFailure(Exception e) {
                view.showErrorMessage("Đã xảy ra lỗi khi tải ảnh lên. Vui lòng thử lại.");
            }
        });
    }

    private class SaveFeedbackTask extends AsyncTask<Void, Void, Boolean> {
        private String userId;
        private String idBookedTour;
        private String comment;
        private int rating;
        private String date;
        private String time;
        private List<String> firebaseImageUrls;
        private Exception exception;

        SaveFeedbackTask(String userId, String idBookedTour, String comment, int rating, String date, String time, List<String> firebaseImageUrls) {
            this.userId = userId;
            this.idBookedTour = idBookedTour;
            this.comment = comment;
            this.rating = rating;
            this.date = date;
            this.time = time;
            this.firebaseImageUrls = firebaseImageUrls;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            SQLServerDataSource dataSource = new SQLServerDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String query = "INSERT INTO Feedback (IdBookedTour, DescriptionFeedback, Rating, DateOfFeedback, TimeOfFeedback) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, idBookedTour);
                    preparedStatement.setString(2, comment);
                    preparedStatement.setInt(3, rating);
                    preparedStatement.setString(4, date);
                    preparedStatement.setString(5, time);
                    preparedStatement.executeUpdate();

                    int feedbackId = 0;
                    try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                        if (rs.next()) {
                            feedbackId = rs.getInt(1);
                        }
                    }

                    String queryImage = "INSERT INTO ImgFeedback (IdFeedback, ImgResource) VALUES (?, ?)";
                    try (PreparedStatement preparedStatementImage = connection.prepareStatement(queryImage)) {
                        for (String imageUri : firebaseImageUrls) {
                            preparedStatementImage.setInt(1, feedbackId);
                            preparedStatementImage.setString(2, imageUri);
                            preparedStatementImage.executeUpdate();
                        }
                    }
                }
                return true;
            } catch (SQLException e) {
                logger.severe("Error saving feedback to database: " + e.getMessage());
                exception = e;
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                view.showSuccessMessage("Cảm ơn bạn đã đánh giá!");
                view.navigateBack();
            } else {
                view.showErrorMessage("Đã xảy ra lỗi khi lưu CSDL. Vui lòng thử lại.");
            }
        }
    }

    private void uploadImagesToFirebase(List<String> imageUris, FirebaseUploadCallback callback) {
        List<String> firebaseImageUrls = new ArrayList<>();
        for (String imageUri : imageUris) {
            Uri uri = Uri.parse(imageUri);
            String fileName = UUID.randomUUID().toString() + ".jpg";
            StorageReference storageReference = FirebaseStorage.getInstance().getReference("Img_Feedback")
                    .child(userId)
                    .child(idBookedTour)
                    .child(fileName);

            storageReference.putFile(uri)
                    .addOnSuccessListener(taskSnapshot -> storageReference.getDownloadUrl().addOnSuccessListener(downloadUri -> {
                        firebaseImageUrls.add(downloadUri.toString());
                        if (firebaseImageUrls.size() == imageUris.size()) {
                            callback.onUploadSuccess(firebaseImageUrls);
                        }
                    }))
                    .addOnFailureListener(callback::onUploadFailure);
        }
    }

    @Override
    public void checkPermissions(Activity activity) {
        String[] permissions = {
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
        };

        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray(new String[0]), REQUEST_PERMISSIONS_CODE);
        }
    }

    @Override
    public void openImagePicker(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        activity.startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
    }

    @Override
    public void handleActivityResult(int requestCode, int resultCode, @Nullable Intent data, Activity activity, List<String> imageUris) {
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
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
            view.updateImageList(imageUris);
        }
    }

    public interface FirebaseUploadCallback {
        void onUploadSuccess(List<String> firebaseImageUrls);
        void onUploadFailure(Exception e);
    }
}
