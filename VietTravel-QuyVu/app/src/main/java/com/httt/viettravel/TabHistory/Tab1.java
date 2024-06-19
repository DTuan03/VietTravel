package com.httt.viettravel.TabHistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.httt.viettravel.R;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.Presenter.UnratedPresenter;
import com.httt.viettravel.Presenter.UnratedPresenterImpl;
import com.httt.viettravel.TabHistory.Tab1Adapter;
import com.httt.viettravel.TabHistory.UnratedView;

import java.util.List;
import java.util.ArrayList;

public class Tab1 extends Fragment implements UnratedView {
    private RecyclerView recyclerView;
    private Tab1Adapter tab1Adapter;
    private UnratedPresenter unratedPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tab1Adapter = new Tab1Adapter(getContext(), new ArrayList<Tour>());
        recyclerView.setAdapter(tab1Adapter);

        unratedPresenter = new UnratedPresenterImpl(this); // Đảm bảo 'this' được truyền vào constructor
        unratedPresenter.loadUnratedTours();

        return view;
    }

    @Override
    public void showUnratedTours(List<Tour> tours) {
        tab1Adapter.setTours(tours);
        tab1Adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        // Hiển thị trạng thái loading
    }

    @Override
    public void hideLoading() {
        // Ẩn trạng thái loading
    }

    @Override
    public void showError(String message) {
        // Hiển
    }
}













//package com.httt.viettravel.TabHistory;
//
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.httt.viettravel.Presenter.UnratedPresenterImpl;
//import com.httt.viettravel.Presenter.UnratedPresenter;
//import com.httt.viettravel.R;
//import com.httt.viettravel.Model.Tour;
//import java.util.List;
//import java.util.ArrayList;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Tab1#newInstance} factory method to
// * create an instance of this fragment.
// *
// */
//public class Tab1 extends Fragment implements UnratedView{
//
//    private RecyclerView recyclerView;
//    private Tab1Adapter tab1Adapter;
//    private UnratedPresenter unratedPresenter;
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Tab1.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Tab1 newInstance(String param1, String param2) {
//        Tab1 fragment = new Tab1();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    public Tab1() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
//
//        recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        tab1Adapter = new Tab1Adapter(getContext(), new ArrayList<>());
//        recyclerView.setAdapter(tab1Adapter);
//
//        unratedPresenter = new UnratedPresenterImpl(this); // Sử dụng Presenter phù hợp
//        unratedPresenter.loadUnratedTours();
//
//        return view;
//    }
//
////    @SuppressLint("NotifyDataSetChanged")
//    @Override
//    public void showUnratedTours(List<Tour> tours) {
//        tab1Adapter.setTours(tours);
//        tab1Adapter.notifyDataSetChanged();
//    }
//
//
//    @Override
//    public void showLoading() {
//
//    }
//
//    @Override
//    public void hideLoading() {
//
//    }
//
//    @Override
//    public void showError(String message) {
//
//    }
//}