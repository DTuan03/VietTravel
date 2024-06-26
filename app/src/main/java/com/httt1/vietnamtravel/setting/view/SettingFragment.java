package com.httt1.vietnamtravel.setting.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.account.view.AccountActivity;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.myvoucher.view.MyVoucherActivity;
import com.httt1.vietnamtravel.regis.view.RegisActivity;
import com.httt1.vietnamtravel.replacePass.view.ReplacePassActivity;
import com.httt1.vietnamtravel.setting.presenter.SettingContract;
import com.httt1.vietnamtravel.setting.presenter.SettingPresenter;

public class SettingFragment extends Fragment implements SettingContract.View{
    private TextView tvName;
    private LinearLayout llAccount, llReplacePass, llCard, llSupport, llFeedback, llMyVoucher, llLogOut;
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
        settingPresenter.setClick(userId);
        return view;
    }
    private void init(View view){
        tvName = view.findViewById(R.id.fragment_setting_tv_name_user);
        llAccount = view.findViewById(R.id.fragment_setting_ll_info_account);
        llReplacePass = view.findViewById(R.id.fragment_setting_ll_pass);
        llCard = view.findViewById(R.id.fragment_setting_ll_card);
        llFeedback = view.findViewById(R.id.fragment_setting_ll_feedback);
        llSupport = view.findViewById(R.id.fragment_setting_ll_support);
        llMyVoucher = view.findViewById(R.id.fragment_setting_ll_voucher);
        llLogOut = view.findViewById(R.id.fragment_setting_ll_logout);
    }

    @Override
    public void setText(String string) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvName.setText(string);
            }
        });
    }

    @Override
    public void onRegis() {
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void notifi() {
        Toast.makeText(getContext(), "Bạn chưa đăng nhập!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAccount() {
        llAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AccountActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onReplacePass() {
        llReplacePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReplacePassActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCard() {

    }

    @Override
    public void onFeedBack() {

    }

    @Override
    public void onSupport() {

    }

    @Override
    public void onMyVoucher() {
        llMyVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyVoucherActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onLogOut() {

    }


}