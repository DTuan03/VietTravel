package com.httt1.vietnamtravel.DetailTour.presenter;

import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;

import java.util.List;

public interface DetailTourActivityContract {
    interface View{
        void showDetailData(HomeModel detailTour);
    }

    interface Presenter{
        void getDetailData(int userId, String tourId);
    }
}
