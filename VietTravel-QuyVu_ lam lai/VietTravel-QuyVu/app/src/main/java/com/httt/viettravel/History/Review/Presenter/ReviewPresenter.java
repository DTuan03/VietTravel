package com.httt.viettravel.History.Review.Presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.httt.viettravel.Connection.SQL.ConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReviewPresenter implements ReviewContract.Presenter {

    private ReviewContract.View view;
    private static final int PICK_IMAGE_REQUEST_CODE = 200;
    private static final int REQUEST_PERMISSIONS_CODE = 123;
    private String idBookedTour;
    private String userId;

    public ReviewPresenter(ReviewContract.View view) {
        this.view = view;
    }

    @Override
    public void submitFeedback(String userId, String idBookedTour, String comment, int rating, String date, String time, List<String> imageUris) {
        this.idBookedTour = idBookedTour;
        this.userId = userId;

        // Tải ảnh lên Firebase và lưu URL vào CSDL
        uploadImagesToFirebase(imageUris, new FirebaseUploadCallback() {
            @Override
            public void onUploadSuccess(List<String> firebaseImageUrls) {
                saveFeedbackToDatabase(userId, idBookedTour, comment, rating, date, time, firebaseImageUrls);
            }

            @Override
            public void onUploadFailure(Exception e) {
                view.showErrorMessage("Đã xảy ra lỗi khi tải ảnh lên. Vui lòng thử lại.");
            }
        });
    }

    private void saveFeedbackToDatabase(String userId, String idBookedTour, String comment, int rating, String date, String time, List<String> firebaseImageUrls) {
        Connection connection = ConnectSQL.CONN();
        if (connection != null) {
            try {
                String query = "INSERT INTO Feedback (IdBookedTour, DescriptionFeedback, Rating, DateOfFeedback, TimeOfFeedback) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, idBookedTour);
                preparedStatement.setString(2, comment);
                preparedStatement.setInt(3, rating);
                preparedStatement.setString(4, date);
                preparedStatement.setString(5, time);
                preparedStatement.executeUpdate();

                // Lấy ID phản hồi vừa được tạo. Lấy idfeedback khi vừa thêm vào CSDL
                ResultSet rs = preparedStatement.getGeneratedKeys();
                int feedbackId = 0;
                if (rs.next()) {
                    feedbackId = rs.getInt(1);
                }

                for (String imageUri : firebaseImageUrls) {
                    String queryImage = "INSERT INTO ImgFeedback (IdFeedback, ImgResource) VALUES (?, ?)";
                    PreparedStatement preparedStatementImage = connection.prepareStatement(queryImage);
                    preparedStatementImage.setInt(1, feedbackId);
                    preparedStatementImage.setString(2, imageUri);
                    preparedStatementImage.executeUpdate();
                }

                preparedStatement.close();
                connection.close();
                view.showSuccessMessage("Cảm ơn bạn đã đánh giá!");
                view.navigateBack();

            } catch (SQLException e) {
                e.printStackTrace();
                view.showErrorMessage("Đã xảy ra lỗi khi luu CSDL. Vui lòng thử lại.");
            }
        } else {
            view.showErrorMessage("Không thể kết nối đến cơ sở dữ liệu.");
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
                    .addOnFailureListener(e -> callback.onUploadFailure(e));
        }
    }
//Cho phép truy cập vào bộ nhớ và đọc hay không
    @Override
    public void checkPermissions(Activity activity) {
        String[] permissions = {
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
        };

        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            //kiểm tra cấp quyêền chưa
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
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  //Cho phép người dùng chọn ảnh tử thiết bị
        intent.setType("image/*"); //image để hiển thị các tệp ảnh, * lấydđịnh dạng
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); //Chọn nhiều ảnh cùng lúc
        activity.startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
    }

    @Override
    public void handleActivityResult(int requestCode, int resultCode, @Nullable Intent data, Activity activity, List<String> imageUris) {
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
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

    public interface FirebaseUploadCallback {
        void onUploadSuccess(List<String> firebaseImageUrls);
        void onUploadFailure(Exception e);
    }
}
