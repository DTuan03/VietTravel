package com.httt1.vietnamtravel.home.presenter;

import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.List;

public interface HomeContract {
    interface View{
        void showDataCombo(List<HomeModel> list);
        void showDataVoucher(List<HomeModel> list, int userId);
        void notifVoucher(int userId, boolean myVoucher);
    }
    interface Presenter{
        void getDataCombo(String typeTour, int userId);
        void getDataVoucher(int userId);
        void onMyVoucher(int userId, int voucherId);
    }

    interface clickVoucher{
        void saveVoucher(int voucherId);
    }
}
