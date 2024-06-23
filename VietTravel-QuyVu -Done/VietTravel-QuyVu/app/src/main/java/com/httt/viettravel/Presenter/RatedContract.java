package com.httt.viettravel.Presenter;

import com.httt.viettravel.Model.Feedback;

import java.util.List;

public interface RatedContract {
    interface View {
        void showRatedTours(List<Feedback> feedbacks);
        void showLoading();
        void hideLoading();
        void showError(String message);
    }

    interface Presenter {
        void loadRatedTours();
    }
}
