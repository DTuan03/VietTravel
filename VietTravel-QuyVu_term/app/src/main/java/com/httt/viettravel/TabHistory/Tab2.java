package com.httt.viettravel.TabHistory;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.httt.viettravel.Adapter.HistoryAdatper;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;
import com.httt.viettravel.ReviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2 extends Fragment {
    private RecyclerView recyclerView;
    private Tab2Adapter tab2Adapter;
    private List<Tour>tourList;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        // Tìm RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);

        // Lấy dữ liệu từ Bundle
        ArrayList<Tour> tourList = null;
        Bundle bundle = getArguments();
        if (bundle != null) {
            tourList = bundle.getParcelableArrayList("data");
        }

        // Cài đặt RecyclerView
        Tab2Adapter tab2Adapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tab2Adapter = new Tab2Adapter(tourList != null ? tourList : new ArrayList<>());
        recyclerView.setAdapter(tab2Adapter);

        return view;
    }


}