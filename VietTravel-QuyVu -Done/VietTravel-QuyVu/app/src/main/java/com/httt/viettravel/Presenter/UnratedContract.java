package com.httt.viettravel.Presenter;

import com.httt.viettravel.Model.Tour;
import java.util.List;

public interface UnratedContract {
    interface View {
        void showUnratedTours(List<Tour> tours);
        void showLoading();
        void hideLoading();
        void showError(String message);
    }

    interface Presenter {
        void loadUnratedTours();
    }
}
