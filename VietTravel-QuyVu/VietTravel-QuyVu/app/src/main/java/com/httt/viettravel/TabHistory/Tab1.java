package com.httt.viettravel.TabHistory;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Tab1 extends Fragment {

    private RecyclerView recyclerView;
    private TextView emtyView;
    private Tab1Adapter tab1Adapter;
    private List<Tour> tours;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Tab1() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        emtyView = view.findViewById(R.id.empty_view);
        tab1Adapter = new Tab1Adapter(tours, getContext()); // Tạo adapter của RecyclerView

        tours = new ArrayList<>();
        tours.add(new Tour(R.drawable.halong, "Tham quan vịnh hạ long", "Hà Nội - Phú Quốc", "\tHang Sửng Sốt \n-\tHang Luồn \n-\t Đảo Ti Top \n-\tVịnh Hạ long", "\t\t2 ngày 1 đêm", "\t\t2.500.000 VND", "\t\tÔ tô", "\t\tKhách sạn Mường Thanh", null,0,null,null));
        tours.add(new Tour(R.drawable.halong, "Tham quan vịnh hạ long", "Hà Nội - Phú Quốc", "\tHang Sửng Sốt \n-\tHang Luồn \n-\t Đảo Ti Top \n-\tVịnh Hạ long", "\t\t2 ngày 1 đêm", "\t\t2.500.000 VND", "\t\tÔ tô", "\t\tKhách sạn Mường Thanh", null,0,null,null));
        tours.add(new Tour(R.drawable.halong, "Tham quan vịnh hạ long", "Hà Nội - Phú Quốc", "\tHang Sửng Sốt \n-\tHang Luồn \n-\t Đảo Ti Top \n-\tVịnh Hạ long", "\t\t2 ngày 1 đêm", "\t\t2.500.000 VND", "\t\tÔ tô", "\t\tKhách sạn Mường Thanh", null,0,null,null));

        checkData();
        return view;
    }

    private void checkData() {
        if (tours.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emtyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emtyView.setVisibility(View.GONE);

            // Khởi tạo adapter với danh sách dữ liệu
            tab1Adapter = new Tab1Adapter(tours,getContext());
//            recyclerView.setAdapter(tab1Adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            tab1Adapter.setData(tours);
            recyclerView.setAdapter(tab1Adapter);

        }
    }
}