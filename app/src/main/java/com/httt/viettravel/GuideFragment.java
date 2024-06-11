package com.httt.viettravel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.httt.viettravel.Adapter.GuideAdapter;
import com.httt.viettravel.Model.Guide;
import com.httt.viettravel.Model.Guide;

import java.util.ArrayList;
import java.util.List;

public class GuideFragment extends Fragment {
    private RecyclerView recyclerView;
    private GuideAdapter guideAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public GuideFragment() {
        // Required empty public constructor
    }
    public static GuideFragment newInstance(String param1, String param2) {
        GuideFragment fragment = new GuideFragment();
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
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        init(view);

        guideAdapter = new GuideAdapter();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        
        guideAdapter.setData(getList());
        recyclerView.setAdapter(guideAdapter);
        return view;
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.fragment_guide_rcv);
    }

    private List<Guide> getList(){
        List<Guide> list = new ArrayList<>();
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));
        list.add(new Guide(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi"));

        return list;
    }
}