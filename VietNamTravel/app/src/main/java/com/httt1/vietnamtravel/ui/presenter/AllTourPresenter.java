package com.httt1.vietnamtravel.ui.presenter;

import com.httt1.vietnamtravel.ui.model.AllTourRepository;
import com.httt1.vietnamtravel.ui.model.HomeRepository;
import com.httt1.vietnamtravel.ui.model.TourModel;

import java.util.List;

public class AllTourPresenter implements AllTourActivityContract.Presenter {
    private final AllTourActivityContract.View view;
    private List<TourModel> list; // Biến instance để lưu trữ danh sách

    AllTourRepository allTourRepository = new AllTourRepository();

    public AllTourPresenter(AllTourActivityContract.View view) {
        this.view = view;
        this.allTourRepository = new AllTourRepository();
    }


    public AllTourRepository getAllTourRepository() {
        return allTourRepository;
    }

    public void setAllTourRepository(HomeRepository homeRepository) {
        this.allTourRepository = allTourRepository;
    }

    @Override
    public void getAllData(int userId) {
        allTourRepository.getAllTour(userId, new AllTourRepository.AllTourCallBack() {
            @Override
            public void listAllTour(List<TourModel> listFavoriteTour) {
                list = listFavoriteTour;
                view.showAllData(list);
            }
        });
    }
}
