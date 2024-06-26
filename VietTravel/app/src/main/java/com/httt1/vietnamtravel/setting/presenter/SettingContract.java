package com.httt1.vietnamtravel.setting.presenter;

import android.widget.TextView;

public interface SettingContract {
    interface View{
        void setText(String string);
        void onRegis();
        void notifi();
        void onAccount();
        void onReplacePass();
        void onCard();
        void onFeedBack();
        void onSupport();
        void onMyVoucher();
        void onLogOut();
    }

    interface Presenter{
        void setNameUser(int userId);
        void setClick(int userId);
    }
}
