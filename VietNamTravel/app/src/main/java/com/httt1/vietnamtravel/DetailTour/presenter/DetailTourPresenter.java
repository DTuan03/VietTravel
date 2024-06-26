package com.httt1.vietnamtravel.DetailTour.presenter;

import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.DetailTour.model.DetailRepository;
import com.httt1.vietnamtravel.DetailTour.presenter.DetailTourActivityContract;
import com.httt1.vietnamtravel.home.model.HomeModel;

public class DetailTourPresenter {
    private final DetailTourActivityContract.View view;
    private final DetailRepository detailRepository;

    public DetailTourPresenter(DetailTourActivityContract.View view, DetailRepository detailRepository) {
        this.view = view;
        this.detailRepository = detailRepository;
    }

    public void getDetailData(int userId, int tourId) {
        detailRepository.getDetailTour(userId, tourId, new DetailRepository.DetailCallBack() {
            @Override
            public void onDetailTourLoaded(HomeModel detailTour) {
                view.showDetailData(detailTour);
            }
        });
    }
}

