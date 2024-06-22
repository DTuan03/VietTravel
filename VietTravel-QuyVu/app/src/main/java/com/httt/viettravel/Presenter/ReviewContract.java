package com.httt.viettravel.Presenter;

import android.net.Uri;

import java.util.List;

public interface ReviewContract {
    interface View {
        void showSuccessMessage(String message);
        void showErrorMessage(String message);
        void navigateBack();
    }

    interface Presenter {
        void submitFeedback(String idBookedTour, String comment, int rating, String date, String time, List<Uri> imageUris);
    }
}
