package com.httt1.vietnamtravel.DetailTour.presenter;

import com.httt1.vietnamtravel.DetailTour.model.DetailModel;

import java.util.List;

public interface DetailTourActivityContract {
    interface View{
        void showDetailData(List<DetailModel> list);
    }

    interface Presenter{
        void getDetailData(int userId);
    }
}
