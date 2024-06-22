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
import com.httt.viettravel.R;
import com.httt.viettravel.Model.Feedback;
import com.httt.viettravel.Presenter.RatedPresenter;
import com.httt.viettravel.Presenter.RatedPresenterImpl;

import java.util.List;
import java.util.ArrayList;

public class Tab2 extends Fragment implements RatedView {
    private RecyclerView recyclerView;
    private Tab2Adapter tab2Adapter;
    private RatedPresenter ratedPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewtab2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tab2Adapter = new Tab2Adapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(tab2Adapter);

        ratedPresenter = new RatedPresenterImpl(this);
        ratedPresenter.loadRatedTours();

        // Đăng ký broadcast receiver để lắng nghe sự kiện REVIEW_SAVED
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(reviewSavedReceiver, new IntentFilter("com.httt.viettravel.REVIEW_SAVED"));

        return view;
    }

    private BroadcastReceiver reviewSavedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Cập nhật dữ liệu khi nhận được thông báo đánh giá mới
            ratedPresenter.loadRatedTours();
        }
    };

    @Override
    public void showRatedTours(List<Feedback> feedbacks) {
        tab2Adapter.setFeedbacks(feedbacks);
        tab2Adapter.notifyDataSetChanged();
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
