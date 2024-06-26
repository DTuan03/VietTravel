package com.httt.viettravel.History.Rated.Presenter;

import com.httt.viettravel.History.Rated.Model.RatedRepository;
import com.httt.viettravel.History.Rated.Model.Rated;

import java.util.List;

public class RatedPresenterImpl implements RatedContract.Presenter {
    private RatedContract.View view;
    private RatedRepository repository;

    public RatedPresenterImpl(RatedContract.View view) {
        this.view = view;
        this.repository = new RatedRepository();
    }

    @Override
    public void loadRatedTours() {
        view.showLoading();
        try {
            List<Rated> rateds = repository.getAllFeedback();
            if (rateds.isEmpty()) {
                view.showError("Không có đánh giá nào.");
            } else {
                view.showRatedTours(rateds);
            }
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
