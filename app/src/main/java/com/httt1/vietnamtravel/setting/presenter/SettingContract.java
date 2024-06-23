package com.httt1.vietnamtravel.setting.presenter;

import android.widget.TextView;

public interface SettingContract {
    interface View{
        void setText(String string);
    }

    interface Presenter{
        void setNameUser(int userId);
    }
}
