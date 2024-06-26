package com.httt.viettravel.Feedback.Presenter;

import com.httt.viettravel.Feedback.Model.FeedbackRepository;
import com.httt.viettravel.Feedback.Model.Feedback;

import java.util.List;

public class FeedbackPresenterImpl implements FeedbackContract.Presenter {
    private FeedbackContract.View view;
    private FeedbackRepository repository;

    public FeedbackPresenterImpl(FeedbackContract.View view) {
        this.view = view;
        this.repository = new FeedbackRepository();
    }

    @Override
    public void loadFeedbacks() {
        view.showLoading();
        try {
            List<Feedback> feedbacks = repository.getAllFeedback();
            if (feedbacks.isEmpty()) {
                view.showError("Không có đánh giá nào.");
            } else {
                view.showFeedbacks(feedbacks);
            }
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideLoading();
        }
    }
}
