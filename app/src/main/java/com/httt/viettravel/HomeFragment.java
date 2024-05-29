package com.httt.viettravel;



import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.httt.viettravel.Adapter.ComboAdapter;
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

    private View fragment;

    private ConstraintLayout clTimKiem;

    private ImageView imgCart;

    private EditText etSearch;
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
        return view;
    }

    private void init(View view){
        rcvCombo = view.findViewById(R.id.fragment_home_rcv_combo);
        rcvVoucher = view.findViewById(R.id.fragment_home_rcv_voucher);
        scrollView = view.findViewById(R.id.fragment_home_sv);
        fragment = view.findViewById(R.id.fragment_home);
        clTimKiem = view.findViewById(R.id.fragment_home_cl_tim_kiem);
        imgCart = view.findViewById(R.id.fragmet_home_img_cart);
        etSearch = view.findViewById(R.id.fragment_home_et_search);
    }

    private List<Combo> getListCombo(){
        List<Combo> list = new ArrayList<>();
        list.add(new Combo(R.drawable.img,"Test thu la 1"));
        Log.d("sss", "ssss");
        list.add(new Combo(R.drawable.img,"Test thu la 2"));
        list.add(new Combo(R.drawable.img,"Test thu la 3"));
        list.add(new Combo(R.drawable.img,"Test thu la 4"));
        list.add(new Combo(R.drawable.img,"Test thu la 5"));

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
    
//    private void setStatusBar(){
//        //Mau cua status bar
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.activity_home_status_bar));
//        }
//
//        // Đặt chế độ sáng/tối cho status bar
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (true /* điều kiện của bạn để sử dụng chế độ sáng */) {
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            } else {
//                getWindow().getDecorView().setSystemUiVisibility(0); // Đặt về chế độ tối mặc định
//            }
//        }
//    }
//
//    private Window getWindow() {
//    }

    // Đảm bảo getActivity() không null trước khi gọi getWindow()
    private void setStatusBar(View view) {
        // Đảm bảo getActivity() không null trước khi gọi getWindow()
        if (true) {
            Window window = getActivity().getWindow();
            // Màu của status bar
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.activity_home_status_bar));
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if(scrollY > oldScrollY){
                        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));
                        clTimKiem.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                        imgCart.setImageResource(R.mipmap.fragment_home_cart_black_adaptive_fore);
                        etSearch.setBackgroundResource(R.drawable.fragment_home_bacground_search_after);
                    }
                    if(scrollY > 20){
                        fragment.setBackgroundResource(R.color.white);
                    }
                    if(scrollY < 5){
                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.activity_home_status_bar));
                        clTimKiem.setBackgroundResource(R.drawable.fragment_home_background_cl_search_after);
                        imgCart.setImageResource(R.mipmap.fragment_home_cart_adaptive_fore);
                    }
                }
            });
        }
    }
}