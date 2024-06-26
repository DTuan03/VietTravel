package com.httt.viettravel.Feedback.Presenter;

import com.httt.viettravel.Feedback.Model.Feedback;

import java.util.List;

public interface FeedbackContract {
    interface View {
        void showFeedbacks(List<Feedback> feedbacks);
        void showLoading();
        void hideLoading();
        void showError(String message);
    }

    interface Presenter {
        void loadFeedbacks();
    }
}
