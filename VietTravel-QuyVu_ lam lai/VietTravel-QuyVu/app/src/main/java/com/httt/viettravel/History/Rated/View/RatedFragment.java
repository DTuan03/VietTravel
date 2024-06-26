package com.httt.viettravel.History.Rated.View;

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

import com.httt.viettravel.History.Rated.Model.Rated;
import com.httt.viettravel.History.Rated.Adapter.RatedAdapter;
import com.httt.viettravel.History.Rated.Presenter.RatedContract;
import com.httt.viettravel.History.Rated.Presenter.RatedPresenterImpl;
import com.httt.viettravel.R;

import java.util.ArrayList;
import java.util.List;

public class RatedFragment extends Fragment implements RatedContract.View {
    private RecyclerView recyclerView;
    private RatedAdapter ratedAdapter;
    private RatedContract.Presenter ratedPresenter;
    private TextView emptyView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rated, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_rated);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyView = view.findViewById(R.id.empty_view_rated);

        ratedAdapter = new RatedAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(ratedAdapter);

        ratedPresenter = new RatedPresenterImpl(this);
        ratedPresenter.loadRatedTours();

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(reviewSavedReceiver, new IntentFilter("com.httt.viettravel.ACTION_REVIEW_SUBMITTED"));

        return view;
    }

    private BroadcastReceiver reviewSavedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ratedPresenter.loadRatedTours();
        }
    };

    @Override
    public void showRatedTours(List<Rated> rateds) {
        ratedAdapter.setFeedbacks(rateds);
        ratedAdapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        // Hiển thị trạng thái loading
    }

    @Override
    public void hideLoading() {
        // Ẩn trạng thái loading
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
