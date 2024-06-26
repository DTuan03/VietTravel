package com.httt1.vietnamtravel.home.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.home.adapter.DiscoverAdapter;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.httt1.vietnamtravel.home.presenter.HomeContract;
import com.httt1.vietnamtravel.home.presenter.HomePresenter;

import java.util.List;

public class TabFavoriteFragment extends Fragment implements HomeContract.View {

    private DiscoverAdapter discoverAdapter;
    private RecyclerView rcvTabFavorite;
    private HomePresenter homePresenter;
    private HomeRepository homeRepository;

    public TabFavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_favorite, container, false);

        rcvTabFavorite = view.findViewById(R.id.fragment_tab_favorite_rcv);
        homePresenter = new HomePresenter(this, requireContext());
        homeRepository = new HomeRepository(); // Tạo instance của HomeRepository

        int userId = 1; // Example: Replace with your logic to get userId
        homePresenter.getDataDiscover("favorite", userId);

        setupRecyclerView(userId);

        return view;
    }

    private void setupRecyclerView(int userId) {
        homePresenter.getHomeRepository();
        discoverAdapter = new DiscoverAdapter(requireContext(), userId, homeRepository);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        rcvTabFavorite.setLayoutManager(gridLayoutManager);
        rcvTabFavorite.setAdapter(discoverAdapter);
    }

    @Override
    public void showDataCombo(List<HomeModel> list) {
        // Implement this if needed
    }

    @Override
    public void showDataVoucher(List<HomeModel> list, int userId) {
        // Implement this if needed
    }

    @Override
    public void showDataDiscover(List<HomeModel> list) {
        getActivity().runOnUiThread(() -> {
            discoverAdapter.setDataDiscover(list);
            discoverAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void notifVoucher(int userId, boolean myVoucher) {
        // Implement this if needed
    }
}
