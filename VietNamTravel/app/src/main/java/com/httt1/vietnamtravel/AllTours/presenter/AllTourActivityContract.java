package com.httt1.vietnamtravel.AllTours.presenter;

import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.List;

public interface AllTourActivityContract {
    interface View{
        void showAllData(List<HomeModel> list);
    }

    interface Presenter{
        void getAllData(int userId);
    }
}
