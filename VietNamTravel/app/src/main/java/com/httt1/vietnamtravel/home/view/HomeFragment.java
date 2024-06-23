package com.httt1.vietnamtravel.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.databinding.FragmentHomeBinding;
import com.httt1.vietnamtravel.home.adapter.TourAdapter;
import com.httt1.vietnamtravel.home.model.TourModel;
import com.httt1.vietnamtravel.home.presenter.HomeContract;
import com.httt1.vietnamtravel.home.presenter.HomePresenter;
import com.httt1.vietnamtravel.AllTours.view.AllTourActivity;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View
 {

    private FragmentHomeBinding binding;
    private RecyclerView rcvCombo, rcvVoucher;
    private TourAdapter comboAdapter;
    private TextView tvSeeMore;
//    private VoucherAdapter voucherAdapter;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private ScrollView scrollView;
    private ImageView imgCart;
    private EditText etSearch;
    private boolean isScrolled = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(requireContext()); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        int userId = 1;
        Log.d("Thong tin UserId 18:03", "Thong tin: " + userId);
        rcvCombo = binding.fragmentHomeRcvCombo;
        rcvVoucher = binding.fragmentHomeRcvVoucher;
//        viewPager2 = view.findViewById(R.id.fragment_home_view_page2);
//        tabLayout = view.findViewById(R.id.fragment_home_tab_layout);
//        scrollView = view.findViewById(R.id.fragment_home_sv);
//        imgCart = view.findViewById(R.id.fragmet_home_img_cart);
//        etSearch = view.findViewById(R.id.fragment_home_et_search);

        HomePresenter homePresenter = new HomePresenter(this, getContext());

        setComboAdapter(homePresenter, userId);

        tvSeeMore = binding.fragmentHomeTvSeemore;
        tvSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllTourActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });

        return root;
    }

    private void setComboAdapter(HomePresenter homePresenter, int userId ){
//        comboAdapter = new TourAdapter();
        comboAdapter = new TourAdapter(getContext(), userId, homePresenter.getHomeRepository());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcvCombo.setLayoutManager(linearLayoutManager);
        rcvCombo.setAdapter(comboAdapter);

        homePresenter.getDataCombo("CB", userId);
    }

    @Override
    public void showDataCombo(List<TourModel> list) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Cập nhật dữ liệu vào adapter và RecyclerView
                comboAdapter.setDataCombo(getContext(), list);
                comboAdapter.notifyDataSetChanged();
            }
        });
    }

     @Override
     public void showDataVoucher(List<TourModel> list) {

     }

     @Override
     public void showDataDiscover(List<TourModel> list) {

     }

     @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}