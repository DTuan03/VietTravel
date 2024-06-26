package com.httt1.vietnamtravel.logOut.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.home.view.HomeFragment;
import com.httt1.vietnamtravel.main.view.MainActivity;


public class LogOutFragment extends DialogFragment {
    private Button btnCancel, btnConf;
    private SharedPrefsHelper sharedPrefsHelper;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LogOutFragment() {
        // Required empty public constructor
    }
    public static LogOutFragment newInstance(String param1, String param2) {
        LogOutFragment fragment = new LogOutFragment();
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
        sharedPrefsHelper = new SharedPrefsHelper(requireContext());
        View view = inflater.inflate(R.layout.fragment_log_out, container, false);
        init(view);
        setBtnCancel();
        setBtnConf();
        return view;
    }

    private void init(View view){
        btnCancel = view.findViewById(R.id.fragment_log_out_btn_cancel);
        btnConf = view.findViewById(R.id.fragment_log_out_btn_conf);
    }

    private void setBtnCancel(){
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    private void setBtnConf(){
        btnConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefsHelper.removeString("UserId");
                Fragment fragmentHome = new HomeFragment();
                MainActivity mainActivity = (MainActivity) getActivity();
                if (mainActivity != null) {
                    mainActivity.loadFragment(fragmentHome, R.color.fragment_home_status_bar);
                }
                dismiss();
            }
        });
    }

}