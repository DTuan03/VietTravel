package com.httt1.vietnamtravel.replacePass.presenter;

import android.widget.EditText;
import android.widget.ImageView;

public interface ReplaceContract {
    interface View{
        void forcus();
        String getPassOld();
        String getPassNew();
        String getPassCf();
        void notifi();
    }
    interface Presenter{
        void onEyePassClicked(ImageView eye, EditText pass);
        void onClickReplace(int userId);
    }
}
