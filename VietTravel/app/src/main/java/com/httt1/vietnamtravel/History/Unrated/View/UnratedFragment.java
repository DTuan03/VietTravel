package com.httt1.vietnamtravel.History.Unrated.View;

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

import com.httt1.vietnamtravel.History.Unrated.Adapter.UnratedAdapter;
import com.httt1.vietnamtravel.History.Unrated.Model.Tour;
import com.httt1.vietnamtravel.History.Unrated.Presenter.UnratedContract;
import com.httt1.vietnamtravel.History.Unrated.Presenter.UnratedPresenterImpl;
import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

public class UnratedFragment extends Fragment implements UnratedContract.View {
    private RecyclerView recyclerView;
    private UnratedAdapter unratedAdapter;
    private UnratedContract.Presenter unratedPresenter;
    private TextView emptyView;
    private int userId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unrated, container, false);
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(requireContext()); // Use 'this' for Activity context
        userId = sharedPrefsHelper.getInt("UserId");

        recyclerView = view.findViewById(R.id.recyclerView_unrated);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyView = view.findViewById(R.id.empty_view_unrated);

        unratedAdapter = new UnratedAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(unratedAdapter);

        unratedPresenter = new UnratedPresenterImpl(this);
        unratedPresenter.loadUnratedTours();

        //LocalBroadcastManager.getInstance(getContext()).registerReceiver(reviewSavedReceiver, new IntentFilter("com.httt.viettravel.REVIEW_SAVED"));
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(reviewSavedReceiver, new IntentFilter("com.httt.viettravel.ACTION_REVIEW_SUBMITTED"));

        return view;
    }

    private BroadcastReceiver reviewSavedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            unratedPresenter.loadUnratedTours();
        }
    };

    @Override
    public void showUnratedTours(List<Tour> tours) {
        unratedAdapter.setTours(tours);
        unratedAdapter.notifyDataSetChanged();

        if (tours.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
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
        // Hiển thị lỗi
        emptyView.setText(message);
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(reviewSavedReceiver);
    }
}
