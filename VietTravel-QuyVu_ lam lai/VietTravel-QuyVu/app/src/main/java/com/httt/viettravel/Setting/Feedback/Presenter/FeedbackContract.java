package com.httt.viettravel.Setting.Feedback.Presenter;

import com.httt.viettravel.History.Rated.Model.Rated;

import java.util.List;

public interface FeedbackContract {
    interface View {
        void showFeedbacks(List<Rated> rateds);
        void showLoading();
        void hideLoading();
        void showError(String message);
    }

    interface Presenter {
        void loadFeedbacks();
    }
}
