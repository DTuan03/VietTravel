package com.httt1.vietnamtravel.ui.presenter;

import com.httt1.vietnamtravel.ui.model.TourModel;

import java.util.List;

public interface HomeContract {
    interface View{
        void showDataCombo(List<TourModel> list);
        void showDataVoucher(List<TourModel> list);
        void showDataDiscover(List<TourModel> list);
    }
    interface Presenter{
        void getDataCombo(String typeTour, int userId);
//        void getDataVoucher();
        void getDataDiscover(String typeDiscover, int userId);
    }

}
