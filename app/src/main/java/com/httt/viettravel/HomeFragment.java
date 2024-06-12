package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.httt.viettravel.Adapter.ComboAdapter;
import com.httt.viettravel.Adapter.ViewPager2Adapter;
import com.httt.viettravel.Adapter.VoucherAdapter;
import com.httt.viettravel.DistanceItem.SpaceItemDecoration;
import com.httt.viettravel.Model.Combo;
import com.httt.viettravel.Model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rcvCombo;
    private ComboAdapter comboAdapter;
    private RecyclerView rcvVoucher;
    private VoucherAdapter voucherAdapter;
    private ScrollView scrollView;
    private View fragmentHome;
    private ConstraintLayout clTimKiem;
    private ImageView imgCart;
    private EditText etSearch;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    //Bien dùng để kiểm tra xem có cuộn không, nếu có cuộn thì ở ReSum thực hiện đổi maàu, còn nếu mà
    //có cuộn nhưng trước lúc quay về nó lại cuộn trở về đầu có nghĩa là ScroolY = 0 thì sẽ kh thực hiện if trong resum
    private boolean isScrolled = false;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("dd", "Dang o trang thai quay tro lai");
        if (isScrolled){
            Window window = getActivity().getWindow();
            // Màu của status bar
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));
            clTimKiem.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
            imgCart.setImageResource(R.mipmap.fragment_home_cart_black_adaptive_fore);
            etSearch.setBackgroundResource(R.drawable.fragment_home_bacground_search_after);
            fragmentHome.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        setStatusBar(view);
        comboAdapter = new ComboAdapter();
        voucherAdapter = new VoucherAdapter();

        int spacingInPixelsCombo = getResources().getDimensionPixelSize(R.dimen.item_combo);
        int spacingInPicelVoucher = getResources().getDimensionPixelSize(R.dimen.item_combo);

        rcvCombo.addItemDecoration(new SpaceItemDecoration(getActivity(), spacingInPixelsCombo));
        rcvVoucher.addItemDecoration(new SpaceItemDecoration(getActivity(),spacingInPicelVoucher));

        LinearLayoutManager linearLayoutManagerCombo = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        rcvCombo.setLayoutManager(linearLayoutManagerCombo);
        LinearLayoutManager linearLayoutManagerVoucher = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        rcvVoucher.setLayoutManager(linearLayoutManagerVoucher);


        comboAdapter.setData(getListCombo());
        voucherAdapter.setData(getListVoucher());

        rcvCombo.setAdapter(comboAdapter);
        rcvVoucher.setAdapter(voucherAdapter);

        setViewPager2Adapter();
        return view;
    }

    private void init(View view){
        rcvCombo = view.findViewById(R.id.fragment_home_rcv_combo);
        rcvVoucher = view.findViewById(R.id.fragment_home_rcv_voucher);
        scrollView = view.findViewById(R.id.fragment_home_sv);
        fragmentHome = view.findViewById(R.id.fragment_home);
        clTimKiem = view.findViewById(R.id.fragment_home_cl_tim_kiem);
        imgCart = view.findViewById(R.id.fragmet_home_img_cart);
        etSearch = view.findViewById(R.id.fragment_home_et_search);
        tabLayout = view.findViewById(R.id.fragment_home_tab_layout);
        viewPager2 = view.findViewById(R.id.fragment_home_view_page2);
    }

    private List<Combo> getListCombo(){
        List<Combo> list = new ArrayList<>();
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));
        list.add(new Combo(R.drawable.qpc,"Tour tham quan du lich lang Quang Phu Cau tam huong truyen thong lau doi o Ung Hoa", "840,000"));

        return list;
    }

    private List<Voucher> getListVoucher(){
        List<Voucher> list = new ArrayList<>();
        list.add(new Voucher(R.drawable.img));
        list.add(new Voucher(R.drawable.img));
        list.add(new Voucher(R.drawable.img));
        list.add(new Voucher(R.drawable.img));
        list.add(new Voucher(R.drawable.img));

        return list;
    }

    private void setStatusBar(View view) {
        if (true) {
            Window window = getActivity().getWindow();
            // Màu của status bar
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.fragment_home_status_bar));
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if(scrollY > 0){
                        isScrolled = true;
                        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));
                        clTimKiem.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                        imgCart.setImageResource(R.mipmap.fragment_home_cart_black_adaptive_fore);
                        etSearch.setBackgroundResource(R.drawable.fragment_home_bacground_search_after);
                        fragmentHome.setBackgroundResource(R.color.white);
                    }
                    if(scrollY < 5){
                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.fragment_home_status_bar));
                        clTimKiem.setBackgroundResource(R.drawable.fragment_home_background_cl_search_after);
                        scrollView.setBackgroundResource(R.drawable.fragment_home_background_cl_search_after);
                        imgCart.setImageResource(R.mipmap.fragment_home_cart_adaptive_fore);
                        fragmentHome.setBackgroundResource(R.drawable.activity_home_background);
                    }
                    //kiểm tra nếu cuộn trở lại về đầu thì kh thực hiện đổi màu khi resum
                    if (scrollY == 0){
                        isScrolled = false;
                    }
                }
            });
        }
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
                        tab.setText("Cẩm nang du lịch");
                        break;
                }
            }
        }).attach();
    }
}