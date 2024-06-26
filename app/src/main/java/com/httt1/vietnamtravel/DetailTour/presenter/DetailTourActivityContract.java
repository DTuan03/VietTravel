package com.httt1.vietnamtravel.DetailTour.presenter;

import com.httt1.vietnamtravel.DetailTour.model.DetailModel;

public interface DetailTourActivityContract {
    interface View{
        void showDetailData(DetailModel detailTour);
    }

    interface Presenter{
        void getDetailData(int userId, String tourId);
    }
}
