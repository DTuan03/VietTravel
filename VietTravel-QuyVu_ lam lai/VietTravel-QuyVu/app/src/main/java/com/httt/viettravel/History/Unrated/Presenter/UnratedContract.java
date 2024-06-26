package com.httt.viettravel.History.Unrated.Presenter;

import com.httt.viettravel.History.Unrated.Model.Tour;
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
