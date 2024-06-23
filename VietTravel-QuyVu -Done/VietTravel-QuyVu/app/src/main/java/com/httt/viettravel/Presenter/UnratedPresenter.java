package com.httt.viettravel.Presenter;

import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.Model.TourReponsitory;
import java.util.List;

public class UnratedPresenter implements UnratedContract.Presenter {

    private UnratedContract.View view;
    private TourReponsitory tourRepository;

    public UnratedPresenter(UnratedContract.View view) {
        this.view = view;
        this.tourRepository = new TourReponsitory();
    }

    @Override
    public void loadUnratedTours() {
        view.showLoading();
        try {
            List<Tour> tours = tourRepository.getUnratedTours();
            view.showUnratedTours(tours); // Phải trả về một danh sách, dù là rỗng
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
