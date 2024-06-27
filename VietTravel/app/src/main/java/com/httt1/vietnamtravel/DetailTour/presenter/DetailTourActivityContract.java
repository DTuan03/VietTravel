package com.httt1.vietnamtravel.DetailTour.presenter;

import com.httt1.vietnamtravel.DetailTour.model.DetailModel;
import com.httt1.vietnamtravel.History.Rated.Model.Rated;

import java.util.List;

public interface DetailTourActivityContract {
    interface View{
        void showDetailData(DetailModel detailTour);
        void showRatedTours(List<Rated> rateds);
    }

    interface Presenter{
        void getDetailData(int userId, String tourId);
    }
}
