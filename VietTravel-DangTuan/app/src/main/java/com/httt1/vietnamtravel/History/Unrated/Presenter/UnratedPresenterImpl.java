package com.httt1.vietnamtravel.History.Unrated.Presenter;

import com.httt1.vietnamtravel.History.Unrated.Model.Tour;
import com.httt1.vietnamtravel.History.Unrated.Model.TourRepository;
import com.httt1.vietnamtravel.History.Unrated.Model.TourRepository.TourRepositoryCallback;

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
        repository.getUnratedTours("3", new TourRepositoryCallback() {
            @Override
            public void onUnratedToursLoaded(List<Tour> tours) {
                view.hideLoading();
                if (tours.isEmpty()) {
                    view.showError("Không có chuyến đi nào.");
                } else {
                    view.showUnratedTours(tours);
                }
            }

            @Override
            public void onError(Exception e) {
                view.hideLoading();
                view.showError(e.getMessage());
            }
        });
    }
}
