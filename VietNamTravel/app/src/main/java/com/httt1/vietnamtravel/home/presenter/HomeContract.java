package com.httt1.vietnamtravel.home.presenter;

import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;

import java.util.List;

public interface HomeContract {
    interface View{
        void showDataCombo(List<HomeModel> list);
        void showDataVoucher(List<HomeModel> list, int userId);
        void showDataDiscover(List<HomeModel> list);
        void notifVoucher(int userId, boolean myVoucher);
    }

    interface Presenter{
        void getDataCombo(String typeTour, int userId);
        void getDataVoucher(int userId);
        void getDataDiscover(String typeDiscover, int userId);
        void onMyVoucher(int userId, int voucherId);
    }

    interface clickVoucher{
        void saveVoucher(int voucherId);
    }

}
