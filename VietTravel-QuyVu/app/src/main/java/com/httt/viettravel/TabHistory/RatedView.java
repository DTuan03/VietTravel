package com.httt.viettravel.TabHistory;

import com.httt.viettravel.Model.Feedback;
import java.util.List;

public interface RatedView {
    void showRatedTours(List<Feedback> feedbacks);
    void showLoading();
    void hideLoading();
    void showError(String message);
}
