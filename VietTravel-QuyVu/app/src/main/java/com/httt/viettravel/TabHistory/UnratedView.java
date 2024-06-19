package com.httt.viettravel.TabHistory;
import com.httt.viettravel.Model.Tour;

import java.util.List;

public interface UnratedView {

        void showUnratedTours(List<Tour> tours);
        void showLoading();
        void hideLoading();
        void showError(String message);
}
