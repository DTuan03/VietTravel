package com.httt1.vietnamtravel.Feedback.View;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.Feedback.Adapter.FeedbackAdapter;
import com.httt1.vietnamtravel.Feedback.Model.Feedback;
import com.httt1.vietnamtravel.Feedback.Presenter.FeedbackContract;
import com.httt1.vietnamtravel.Feedback.Presenter.FeedbackPresenterImpl;
import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity implements FeedbackContract.View {
    private RecyclerView recyclerView;
    private FeedbackAdapter feedbackAdapter;
    private FeedbackContract.Presenter feedbackPresenter;
    private TextView emptyView;
    private int userId; // Fixed user ID

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); // Use 'this' for Activity context
        userId = sharedPrefsHelper.getInt("UserId"); // Default value 0 if UserId is not found

        recyclerView = findViewById(R.id.recyclerView_feedback);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emptyView = findViewById(R.id.empty_view_feedback);

        feedbackAdapter = new FeedbackAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(feedbackAdapter);

        feedbackPresenter = new FeedbackPresenterImpl(this);
        feedbackPresenter.loadFeedbacks();
    }

    @Override
    public void showFeedbacks(List<Feedback> feedbacks) {
        feedbackAdapter.setFeedbacks(feedbacks);
        feedbackAdapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        // Hiển thị trạng thái loading nếu cần
    }

    @Override
    public void hideLoading() {
        // Ẩn trạng thái loading nếu cần
    }

    @Override
    public void showError(String message) {
        emptyView.setText(message);
        emptyView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}
