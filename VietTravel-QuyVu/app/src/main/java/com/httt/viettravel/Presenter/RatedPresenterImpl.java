package com.httt.viettravel.Presenter;

import com.httt.viettravel.Model.FeedbackRepository;
import com.httt.viettravel.TabHistory.RatedView;

public class RatedPresenterImpl implements RatedPresenter {
    private RatedView view;
    private FeedbackRepository repository;

    public RatedPresenterImpl(RatedView view) {
        this.view = view;
        this.repository = new FeedbackRepository();
    }

    @Override
    public void loadRatedTours() {
        view.showLoading();
        try {
            view.showRatedTours(repository.getAllFeedback());
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
