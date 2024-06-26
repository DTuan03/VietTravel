package com.httt1.vietnamtravel.account.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.account.presenter.AccountContract;
import com.httt1.vietnamtravel.account.presenter.AccountPresenter;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;

public class AccountFragmentDiaLogAddress extends DialogFragment implements AccountContract.ViewDialog {
    private ImageView imgClose;
    private EditText etAddress;
    private Button btnSave;
    private AccountPresenter accountPresenter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AccountFragmentDiaLogAddress() {
        // Required empty public constructor
    }

    public static AccountFragmentDiaLogAddress newInstance(String param1, String param2) {
        AccountFragmentDiaLogAddress fragment = new AccountFragmentDiaLogAddress();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_dia_log_address, container, false);
        init(view);
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(requireContext()); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        int userId = sharedPrefsHelper.getInt("UserId");
        accountPresenter = new AccountPresenter();
        setImgClose();
        setProperties(userId);
        return view;
    }

    private void init(View view){
        imgClose = (ImageView) view.findViewById(R.id.fragment_account_dialog_address_img_close);
        etAddress = view.findViewById(R.id.fragment_account_dialog_address_et);
        btnSave = view.findViewById(R.id.fragment_account_dialog_address_btn);
    }

    private void setImgClose(){
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); //phuong thuc close dialog
            }
        });
    }

    @Override
    public void setProperties(int userId) {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = etAddress.getText().toString();
                if (string.equals("")){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "Bạn không được dể trống", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    accountPresenter.updateProperties("UserAddress", string, userId);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dismiss();
                        }
                    });
                }
            }
        });
    }


}