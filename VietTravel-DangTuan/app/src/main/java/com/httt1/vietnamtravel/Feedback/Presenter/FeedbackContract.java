package com.httt1.vietnamtravel.Feedback.Presenter;

import com.httt1.vietnamtravel.Feedback.Model.Feedback;

import java.util.List;

public interface FeedbackContract {
    interface View {
        void showFeedbacks(List<Feedback> feedbackList);
        void showLoading();
        void hideLoading();
        void showError(String message);
    }

    interface Presenter {
        void loadFeedbacks();
    }
}
