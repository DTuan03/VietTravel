package com.httt1.vietnamtravel.home.presenter;

import android.content.Context;

import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.httt1.vietnamtravel.home.model.TourModel;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter {
    private final HomeContract.View view;
    private List<TourModel> list; // Biến instance để lưu trữ danh sách

    HomeRepository homeRepository = new HomeRepository();

    public HomeRepository getHomeRepository() {
        return homeRepository;
    }

    public void setHomeRepository(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public HomePresenter(HomeContract.View view, Context context){
        this.view = view;
        this.homeRepository = homeRepository;
    }

    @Override
    public void getDataCombo(String typeTour, int userId) {
        homeRepository.getComboTour(userId, new HomeRepository.ComboCallBack() {
            @Override
            public void listCombo(List<TourModel> listFavoriteTour) {
                list = listFavoriteTour;
                view.showDataCombo(list);
            }
        });
    }



//    @Override
//    public void getDataVoucher() {
//        homeRepository.getVoucher(new HomeRepository.VoucherCallBack() {
//            @Override
//            public void listVoucher(List<HomeModel> listVoucher) {
//                list = listVoucher;
//                view.showDataVoucher(list);
//            }
//        });
//    }

    @Override
    public void getDataDiscover(String typeDiscover, int userId) {
        homeRepository.getDiscover(userId, typeDiscover, new HomeRepository.DiscoverCallBack() {
            @Override
            public void listDiscover(List<TourModel> listDiscover) {
                list = listDiscover;
                view.showDataDiscover(list);
            }
        });
    }

}
