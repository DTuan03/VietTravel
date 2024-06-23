package com.httt.viettravel.Presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.httt.viettravel.Connection.SQL.ConnectSQL;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReviewPresenter implements ReviewContract.Presenter {

    private ReviewContract.View view;
    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int PICK_IMAGE_REQUEST_CODE = 200;
    private static final int REQUEST_PERMISSIONS_CODE = 123;

    public ReviewPresenter(ReviewContract.View view) {
        this.view = view;
    }

    @Override
    public void submitFeedback(String idBookedTour, String comment, int rating, String date, String time, List<String> imageUris) {
        Connection connection = ConnectSQL.CONN();
        if (connection != null) {
            try {
                String idFeedback = UUID.randomUUID().toString();
                String query = "INSERT INTO Feedback (IdFeedback, IdBookedTour, DescriptionFeedback, Rating, DateOfFeedback, TimeOfFeedback) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, idFeedback);
                preparedStatement.setString(2, idBookedTour);
                preparedStatement.setString(3, comment);
                preparedStatement.setInt(4, rating);
                preparedStatement.setString(5, date);
                preparedStatement.setString(6, time);
                preparedStatement.executeUpdate();

                for (String imageUri : imageUris) {
                    String idImageFeedback = UUID.randomUUID().toString();
                    String queryImage = "INSERT INTO ImageFeedback (IdImageFeedback, IdFeedback, ImagePath) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatementImage = connection.prepareStatement(queryImage);
                    preparedStatementImage.setString(1, idImageFeedback);
                    preparedStatementImage.setString(2, idFeedback);
                    preparedStatementImage.setString(3, imageUri);
                    preparedStatementImage.executeUpdate();
                }

                preparedStatement.close();
                connection.close();
                view.showSuccessMessage("Cảm ơn bạn đã đánh giá!");
                view.navigateBack();

            } catch (SQLException e) {
                e.printStackTrace();
                view.showErrorMessage("Đã xảy ra lỗi. Vui lòng thử lại.");
            }
        } else {
            view.showErrorMessage("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }

    @Override
    public void checkPermissions(Activity activity) {
        String[] permissions = {
                android.Manifest.permission.CAMERA,
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
    public void handleActivityResult(int requestCode, int resultCode, @Nullable Intent data, Activity activity, List<String> imageUris, String currentPhotoPath) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", new File(currentPhotoPath));
            imageUris.add(imageUri.toString());
            view.updateImageList(imageUris);
        } else if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
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
                view.updateImageList(imageUris);
            }
        }
    }
}
