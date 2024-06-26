package com.httt1.vietnamtravel.account.presenter;

public interface AccountContract {
    interface View{
        void setUserName(String userName);
        void setDate(String userDate);
        void setPhone(String userPhone);
        void setEmail(String userEmail);
        void setAddress(String userAddress);
    }
    interface Presenter{
        void getInfo(int userId);
        void updateProperties(String properties, String values, int userId);
    }
    interface ViewDialog{
        void setProperties(int userId);
    }

    public interface OnDataChangedListener {
        void onDataChanged();
    }
}
