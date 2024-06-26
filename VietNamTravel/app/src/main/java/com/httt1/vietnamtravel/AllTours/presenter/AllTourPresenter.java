package com.httt1.vietnamtravel.AllTours.presenter;

import com.httt1.vietnamtravel.AllTours.model.AllTourRepository;
import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.List;

public class AllTourPresenter implements AllTourActivityContract.Presenter {
    private final AllTourActivityContract.View view;
    private List<HomeModel> list; // Biến instance để lưu trữ danh sách

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
            public void listAllTour(List<HomeModel> listFavoriteTour) {
                list = listFavoriteTour;
                view.showAllData(list);
            }
        });
    }
}
