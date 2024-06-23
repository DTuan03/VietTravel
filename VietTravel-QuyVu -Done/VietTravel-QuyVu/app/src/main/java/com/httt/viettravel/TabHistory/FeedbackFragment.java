package com.httt.viettravel.TabHistory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.R;
import com.httt.viettravel.Model.Feedback;
import com.httt.viettravel.Presenter.RatedContract;
import com.httt.viettravel.Presenter.RatedPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class FeedbackFragment extends Fragment implements RatedContract.View {
    private RecyclerView recyclerView;
    private FeedbackAdapter feedbackAdapter;
    private RatedContract.Presenter ratedPresenter;
    private TextView emptyView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rated, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_rated);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyView = view.findViewById(R.id.empty_view_rated);

        feedbackAdapter = new FeedbackAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(feedbackAdapter);

        ratedPresenter = new RatedPresenterImpl(this);
        ratedPresenter.loadRatedTours();

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(reviewSavedReceiver, new IntentFilter("com.httt.viettravel.REVIEW_SAVED"));

        return view;
    }

    private BroadcastReceiver reviewSavedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ratedPresenter.loadRatedTours();
        }
    };

    @Override
    public void showRatedTours(List<Feedback> feedbacks) {
        if (feedbacks.isEmpty()) {
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            feedbackAdapter.setFeedbacks(feedbacks);
            feedbackAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showLoading() {
        // Show loading state if needed
    }

    @Override
    public void hideLoading() {
        // Hide loading state if needed
    }

    @Override
    public void showError(String message) {
        emptyView.setText(message);
        emptyView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(reviewSavedReceiver);
    }
}
