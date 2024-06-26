package com.httt.viettravel.History.Review.Presenter;

import android.app.Activity;
import android.content.Intent;

import java.util.List;

public interface ReviewContract {
    interface View {
        void showSuccessMessage(String message);
        void showErrorMessage(String message);
        void navigateBack();
        void updateImageList(List<String> imageUris);
    }

    interface Presenter {
        void submitFeedback(String userId, String idBookedTour, String comment, int rating, String date, String time, List<String> imageUris);
        void checkPermissions(Activity activity);
        void openImagePicker(Activity activity);
        void handleActivityResult(int requestCode, int resultCode, Intent data, Activity activity, List<String> imageUris);
    }
}
