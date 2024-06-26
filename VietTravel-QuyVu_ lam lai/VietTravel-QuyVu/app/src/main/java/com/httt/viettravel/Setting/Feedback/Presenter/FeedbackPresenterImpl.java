package com.httt.viettravel.Setting.Feedback.Presenter;

import com.httt.viettravel.History.Rated.Model.Rated;
import com.httt.viettravel.History.Rated.Model.RatedRepository;

import java.util.List;

public class FeedbackPresenterImpl implements FeedbackContract.Presenter {
    private FeedbackContract.View view;
    private RatedRepository repository;

    public FeedbackPresenterImpl(FeedbackContract.View view) {
        this.view = view;
        this.repository = new RatedRepository();
    }

    @Override
    public void loadFeedbacks() {
        view.showLoading();
        try {
            List<Rated> rateds = repository.getAllFeedback();
            view.showFeedbacks(rateds);
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
