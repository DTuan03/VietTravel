package com.httt.viettravel.Presenter;

import com.httt.viettravel.Model.Feedback;
import com.httt.viettravel.Model.FeedbackRepository;

import java.util.List;

public class RatedPresenterImpl implements RatedContract.Presenter {
    private RatedContract.View view;
    private FeedbackRepository repository;

    public RatedPresenterImpl(RatedContract.View view) {
        this.view = view;
        this.repository = new FeedbackRepository();
    }

    @Override
    public void loadRatedTours() {
        view.showLoading();
        try {
            List<Feedback> feedbacks = repository.getAllFeedback();
            if (feedbacks.isEmpty()) {
                view.showError("Không có đánh giá nào.");
            } else {
                view.showRatedTours(feedbacks);
            }
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
