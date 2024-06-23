package com.httt1.vietnamtravel.setting.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.setting.presenter.SettingContract;
import com.httt1.vietnamtravel.setting.presenter.SettingPresenter;

public class SettingFragment extends Fragment implements SettingContract.View{
    private TextView tvName;
    public SettingPresenter settingPresenter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SettingFragment() {
    }


    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(requireContext()); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        int userId = sharedPrefsHelper.getInt("UserId");
        init(view);
        settingPresenter = new SettingPresenter(this);
        settingPresenter.setNameUser(userId);
        return view;
    }
    private void init(View view){
        tvName = view.findViewById(R.id.fragment_setting_tv_name_user);
    }

    @Override
    public void setText(String string) {
        tvName.setText(string);
    }
}