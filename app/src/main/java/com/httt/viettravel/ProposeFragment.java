package com.httt.viettravel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.httt.viettravel.Adapter.ProposeAdapter;
import com.httt.viettravel.Adapter.ProposeAdapter;
import com.httt.viettravel.Model.Propose;
import com.httt.viettravel.Model.Propose;

import java.util.ArrayList;
import java.util.List;


public class ProposeFragment extends Fragment {
    private ProposeAdapter proposeAdapter;
    private RecyclerView recyclerView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProposeFragment() {
    }

    public static ProposeFragment newInstance(String param1, String param2) {
        ProposeFragment fragment = new ProposeFragment();
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
        View view = inflater.inflate(R.layout.fragment_propose, container, false);
        init(view);

        proposeAdapter = new ProposeAdapter();

        //tham so bao gom so cot va hướng hiển thị
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        proposeAdapter.setData(getList());
        recyclerView.setAdapter(proposeAdapter);

        return view;
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.fragment_propose_rcv);
    }

    private List<Propose> getList(){
        List<Propose> list = new ArrayList<>();
        list.add(new Propose(R.drawable.hue5,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.hue1,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.hue1,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));
        list.add(new Propose(R.drawable.qpc,"Tour tham quan lang tam huong quang phu cau lang nghe truyen thong o Ha Noi","5.0", "840,000"));


        return list;
    }
}