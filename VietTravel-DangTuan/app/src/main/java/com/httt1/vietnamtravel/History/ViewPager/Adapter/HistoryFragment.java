package com.httt1.vietnamtravel.History.ViewPager.Adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import com.httt1.vietnamtravel.History.ViewPager.View.TabAdapter;
import com.httt1.vietnamtravel.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    private TabLayout tabLayout1;
    private ViewPager2 viewPager;
    private TabAdapter adapter1;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        tabLayout1 = view.findViewById(R.id.tabLayout1);
        viewPager = view.findViewById(R.id.viewPager1);

        // Khởi tạo TabAdapter và đặt nó vào ViewPager2
        TabAdapter adapter = new TabAdapter(requireActivity());
        viewPager.setAdapter(adapter);

        // Liên kết TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout1, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Chưa đánh giá");
                            break;
                        case 1:
                            tab.setText("Đã đánh giá");
                            break;
                    }
                }).attach();
        return view;
    }


}

