package com.httt1.vietnamtravel.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.httt1.vietnamtravel.DetailTour.view.DetailTourActivity;
import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.databinding.FragmentHomeBinding;
import com.httt1.vietnamtravel.AllTours.view.AllTourActivity;
import com.httt1.vietnamtravel.home.adapter.ComboAdapter;
import com.httt1.vietnamtravel.home.adapter.DiscoverAdapter;
import com.httt1.vietnamtravel.home.adapter.ViewPager2Adapter;
import com.httt1.vietnamtravel.home.adapter.VoucherAdapter;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.presenter.HomeContract;
import com.httt1.vietnamtravel.home.presenter.HomePresenter;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View {

    private FragmentHomeBinding binding;
    private RecyclerView rcvCombo, rcvVoucher;
    private ComboAdapter comboAdapter;
    private DiscoverAdapter discoverAdapter;
    private VoucherAdapter voucherAdapter;
    private TextView tvSeeMore;
    private HomePresenter homePresenter;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    public HomeFragment() {
    }
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(requireContext());
        int userId = 1;
        Log.d("Thong tin UserId", "Thong tin: " + userId);

        rcvCombo = binding.fragmentHomeRcvCombo;
        rcvVoucher = binding.fragmentHomeRcvVoucher;
        tabLayout = binding.fragmrntHomeTabLayout;
        viewPager2 = binding.fragmentHomeViewPageDiscover;

        // Initialize HomePresenter and assign to global variable
        homePresenter = new HomePresenter(this, requireContext());

        setComboAdapter(homePresenter, userId);
        setVoucherAdapter(userId);

        tvSeeMore = binding.fragmentHomeTvSeemore;
        tvSeeMore.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), AllTourActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
        });

        setViewPager2Adapter();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Cập nhật lại dữ liệu khi Fragment được hiển thị lại
        refreshData();
    }

    private void refreshData() {
        // Cập nhật dữ liệu combo
        int userId = 1;
        homePresenter.getDataCombo("CB", userId);
    }

    private void setComboAdapter(HomePresenter homePresenter, int userId) {
        comboAdapter = new ComboAdapter(getContext(), userId, homePresenter.getHomeRepository());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcvCombo.setLayoutManager(linearLayoutManager);
        rcvCombo.setAdapter(comboAdapter);

        comboAdapter.setOnItemClickListener((idTour, idUser) -> {
            Intent intent = new Intent(getActivity(), DetailTourActivity.class);
            intent.putExtra("idTour", idTour);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });

        homePresenter.getDataCombo("CB", userId);
    }

    @Override
    public void showDataCombo(List<HomeModel> list) {
        getActivity().runOnUiThread(() -> {
            comboAdapter.setDataCombo(getContext(), list);
            comboAdapter.notifyDataSetChanged();
        });
    }

    private void setVoucherAdapter(int userId) {
        voucherAdapter = new VoucherAdapter(getContext(), userId, homePresenter.getHomeRepository());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcvVoucher.setLayoutManager(linearLayoutManager);
        rcvVoucher.setAdapter(voucherAdapter);

        homePresenter.getDataVoucher(userId);
    }

    @Override
    public void showDataVoucher(List<HomeModel> list, int userId) {
        getActivity().runOnUiThread(() -> {
            voucherAdapter.setDataVoucher(getContext(), list, voucherId -> homePresenter.onMyVoucher(userId, voucherId));
            voucherAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void notifVoucher(int userId, boolean myVoucher) {
        getActivity().runOnUiThread(() -> {
            if (myVoucher) {
                Toast.makeText(getContext(), "Voucher đã có trong kho!", Toast.LENGTH_SHORT).show();
            } else {
                if (userId != 0) {
                    Toast.makeText(getContext(), "Lưu voucher thành công.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Đăng nhập/Đăng ký để lưu voucher.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showDataDiscover(List<HomeModel> list) {
        getActivity().runOnUiThread(() -> {
            discoverAdapter.setDataDiscover(list);
            discoverAdapter.notifyDataSetChanged();
        });
    }

    private void setViewPager2Adapter(){
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(requireActivity());// Lấy hoạt động liên quan đến fragment
        viewPager2.setAdapter(viewPager2Adapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Đề xuất");
                        break;
                    case 1:
                        tab.setText("Không thể bỏ lỡ");
                        break;
                    case 2:
                        tab.setText("Được yêu thích nhiều nhất");
                        break;
                }
            }
        }).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
