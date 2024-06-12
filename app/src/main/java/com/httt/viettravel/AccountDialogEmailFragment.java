package com.httt.viettravel;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AccountDialogEmailFragment extends DialogFragment {
    private ImageView imgClose;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AccountDialogEmailFragment() {
        // Required empty public constructor
    }

    public static AccountDialogEmailFragment newInstance(String param1, String param2) {
        AccountDialogEmailFragment fragment = new AccountDialogEmailFragment();
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
        View view = inflater.inflate(R.layout.fragment_account_dialog_email, container, false);
        init(view);
        setImgClose();
        return view;
    }

    private void init(View view){
        imgClose = (ImageView) view.findViewById(R.id.fragment_account_dialog_email_img_close);
    }

    private void setImgClose(){
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); //phuong thuc close dialog
            }
        });
    }
}