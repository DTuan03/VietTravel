package com.httt.viettravel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.httt.viettravel.Adapter.RecommendAdapter;
import com.httt.viettravel.Model.Recommend;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment {

    private RecommendAdapter recommendAdapter;
    private RecyclerView recyclerView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public RecommendFragment() {
        // Required empty public constructor
    }
    public static RecommendFragment newInstance(String param1, String param2) {
        RecommendFragment fragment = new RecommendFragment();
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
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        init(view);
        recommendAdapter = new RecommendAdapter();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        
        recommendAdapter.setData(getList());

        recyclerView.setAdapter(recommendAdapter);

        return view;
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.fragment_recommend_rcv);
    }

    private List<Recommend> getList(){
        List<Recommend> list = new ArrayList<>();
        list.add(new Recommend(R.drawable.hue5,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.hue1,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.hue1,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Recommend(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));

        return list;
    }
}