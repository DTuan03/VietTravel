package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.httt.viettravel.Model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class VoucherFragment extends Fragment {
    private RecyclerView rcvVoucher;
    private VoucherAdapter voucherAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public VoucherFragment() {
        // Required empty public constructor
    }
    public static VoucherFragment newInstance(String param1, String param2) {
        VoucherFragment fragment = new VoucherFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_voucher, container, false);
        voucherAdapter = new VoucherAdapter();
        rcvVoucher = view.findViewById(R.id.recycler_view_voucher);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rcvVoucher.setLayoutManager(staggeredGridLayoutManager);

        voucherAdapter.setData(getListVoucher());

        rcvVoucher.setAdapter(voucherAdapter);
        return view;
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