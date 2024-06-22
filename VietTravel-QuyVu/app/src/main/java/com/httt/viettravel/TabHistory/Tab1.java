package com.httt.viettravel.TabHistory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.TourReponsitory;
import com.httt.viettravel.R;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.Presenter.UnratedPresenter;
import com.httt.viettravel.Presenter.UnratedPresenterImpl;

import java.util.List;
import java.util.ArrayList;

public class Tab1 extends Fragment implements UnratedView {
    private RecyclerView recyclerView;
    private Tab1Adapter tab1Adapter;
    private UnratedPresenter unratedPresenter;
    private TourReponsitory tourRepository;
    private static final int REVIEW_REQUEST_CODE = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tab1Adapter = new Tab1Adapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(tab1Adapter);

        unratedPresenter = new UnratedPresenterImpl(this);
        unratedPresenter.loadUnratedTours();

        // Đăng ký broadcast receiver để lắng nghe sự kiện REVIEW_SAVED
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(reviewSavedReceiver, new IntentFilter("com.httt.viettravel.REVIEW_SAVED"));

        return view;
    }

    private BroadcastReceiver reviewSavedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Cập nhật dữ liệu khi nhận được thông báo đánh giá mới
            unratedPresenter.loadUnratedTours();
        }
    };

    @Override
    public void showUnratedTours(List<Tour> tours) {
        tab1Adapter.setTours(tours);
        tab1Adapter.notifyDataSetChanged();
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(reviewSavedReceiver);
    }
}
