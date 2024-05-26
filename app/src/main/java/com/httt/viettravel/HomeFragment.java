package com.httt.viettravel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.httt.viettravel.Adapter.ComboAdapter;
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
        comboAdapter = new ComboAdapter();
        voucherAdapter = new VoucherAdapter();

        rcvCombo = view.findViewById(R.id.fragment_home_rcv_combo);
        rcvVoucher = view.findViewById(R.id.fragment_home_rcv_voucher);

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
}