package com.httt1.vietnamtravel.ui.presenter;

import com.httt1.vietnamtravel.ui.model.TourModel;

import java.util.List;

public interface AllTourActivityContract {
    interface View{
        void showAllData(List<TourModel> list);
    }

    interface Presenter{
        void getAllData(int userId);
    }
}
