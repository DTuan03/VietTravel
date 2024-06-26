package com.httt1.vietnamtravel.History.Rated.Presenter;

import com.httt1.vietnamtravel.History.Rated.Model.Rated;
import java.util.List;

public interface RatedContract {
    interface View {
        void showRatedTours(List<Rated> rateds);
        void showLoading();
        void hideLoading();
        void showError(String message);
    }

    interface Presenter {
        void loadRatedTours();
    }
}
