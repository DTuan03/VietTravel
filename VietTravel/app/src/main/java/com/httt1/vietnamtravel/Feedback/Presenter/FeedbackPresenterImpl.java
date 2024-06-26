package com.httt1.vietnamtravel.Feedback.Presenter;

import com.httt1.vietnamtravel.Feedback.Model.Feedback;
import com.httt1.vietnamtravel.Feedback.Model.FeedbackRepository;

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
        repository.getAllFeedback("1", new FeedbackRepository.FeedbackCallback() {
            @Override
            public void onFeedbackLoaded(List<Feedback> feedbackList) {
                view.hideLoading();
                if (feedbackList.isEmpty()) {
                    view.showError("Không có đánh giá nào.");
                } else {
                    view.showFeedbacks(feedbackList);
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
