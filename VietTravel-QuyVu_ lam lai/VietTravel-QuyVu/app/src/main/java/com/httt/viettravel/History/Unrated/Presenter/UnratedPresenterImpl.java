package com.httt.viettravel.History.Unrated.Presenter;

import com.httt.viettravel.History.Unrated.Model.Tour;
import com.httt.viettravel.History.Unrated.Model.TourRepository;

import java.util.List;

public class UnratedPresenterImpl implements UnratedContract.Presenter {
    private UnratedContract.View view;
    private TourRepository repository;

    public UnratedPresenterImpl(UnratedContract.View view) {
        this.view = view;
        this.repository = new TourRepository();
    }

    @Override
    public void loadUnratedTours() {
        view.showLoading();
        try {
            List<Tour> tours = repository.getUnratedTours();  //hàm bên repository
            if (tours.isEmpty()) {
                view.showError("Không có chuyến đi nào.");
            } else {
                view.showUnratedTours(tours);
            }
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
