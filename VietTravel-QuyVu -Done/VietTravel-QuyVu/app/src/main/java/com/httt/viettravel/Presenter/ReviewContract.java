package com.httt.viettravel.Presenter;

import android.net.Uri;
import java.util.List;

public interface ReviewContract {
    interface View {
        void showSuccessMessage(String message);
        void showErrorMessage(String message);
        void navigateBack();
        void updateImageList(List<String> imageUris);
    }

    interface Presenter {
        void submitFeedback(String idBookedTour, String comment, int rating, String date, String time, List<String> imageUris);
        void checkPermissions(android.app.Activity activity);
        void openImagePicker(android.app.Activity activity);
        void handleActivityResult(int requestCode, int resultCode, android.content.Intent data, android.app.Activity activity, List<String> imageUris, String currentPhotoPath);
    }
}
