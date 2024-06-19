package com.httt.viettravel.Presenter;

import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.Model.TourReponsitory;
import com.httt.viettravel.TabHistory.Tab1;
import com.httt.viettravel.TabHistory.UnratedView;

import java.util.List;

public class UnratedPresenterImpl implements UnratedPresenter {

    private UnratedView view;
    private TourReponsitory tourReponsitory;

    public UnratedPresenterImpl(UnratedView view) {
        if (view == null) {
            throw new IllegalArgumentException("UnratedView cannot be null");
        }
        this.view = view;
        this.tourReponsitory = new TourReponsitory();
    }

    @Override
    public void loadUnratedTours() {
        if (view != null) {
            view.showLoading();
            List<Tour> tours = tourReponsitory.getUnratedTours();
            if (tours != null && !tours.isEmpty()) {
                view.showUnratedTours(tours);
            } else {
                view.showError("No unrated tours found.");
            }
            view.hideLoading();
        }
    }
}
