package com.httt1.vietnamtravel.AllTours.presenter;

import com.httt1.vietnamtravel.AllTours.model.AllTourModel;
import com.httt1.vietnamtravel.AllTours.model.AllTourRepository;


import java.util.List;

public class AllTourPresenter implements AllTourActivityContract.Presenter {
    private final AllTourActivityContract.View view;
    private List<AllTourModel> list; // Biến instance để lưu trữ danh sách

    AllTourRepository allTourRepository = new AllTourRepository();

    public AllTourPresenter(AllTourActivityContract.View view) {
        this.view = view;
        this.allTourRepository = new AllTourRepository();
    }


    public AllTourRepository getAllTourRepository() {
        return allTourRepository;
    }

    public void setAllTourRepository(AllTourRepository allTourRepository) {
        this.allTourRepository = allTourRepository;
    }

    @Override
    public void getAllData(int userId) {
        allTourRepository.getAllTour(userId, new AllTourRepository.AllTourCallBack() {
            @Override
            public void listAllTour(List<AllTourModel> listFavoriteTour) {
                list = listFavoriteTour;
                view.showAllData(list);
            }
        });
    }
}
