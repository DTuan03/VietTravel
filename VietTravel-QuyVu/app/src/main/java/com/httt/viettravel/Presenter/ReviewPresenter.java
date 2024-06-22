package com.httt.viettravel.Presenter;

import android.net.Uri;

import com.httt.viettravel.Connection.SQL.ConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ReviewPresenter {

    private ReviewContract.View view;

    public ReviewPresenter(ReviewContract.View view) {
        this.view = view;
    }

    public void submitFeedback(String idBookedTour, String comment, int rating, String date, String time, List<Uri> imageUris) {
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

                for (Uri imageUri : imageUris) {
                    String idImageFeedback = UUID.randomUUID().toString();
                    String imagePath = imageUri.toString(); // Lưu đường dẫn URI của ảnh
                    String queryImage = "INSERT INTO ImageFeedback (IdImageFeedback, IdFeedback, ImagePath) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatementImage = connection.prepareStatement(queryImage);
                    preparedStatementImage.setString(1, idImageFeedback);
                    preparedStatementImage.setString(2, idFeedback);
                    preparedStatementImage.setString(3, imagePath);
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
}
