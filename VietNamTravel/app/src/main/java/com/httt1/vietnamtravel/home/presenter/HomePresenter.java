package com.httt1.vietnamtravel.home.presenter;

import android.content.Context;

import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter {
    private final HomeContract.View view;
    private List<HomeModel> list; // Biến instance để lưu trữ danh sách

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
            public void listCombo(List<HomeModel> listComboTour) {
                list = listComboTour;
                view.showDataCombo(list);
            }
        });
    }

    @Override
    public void getDataDiscover(String typeDiscover, int userId) {
        homeRepository.getDiscover(userId, typeDiscover, new HomeRepository.DiscoverCallBack() {
            @Override
            public void listDiscover(List<HomeModel> listDiscover) {
                list = listDiscover;
                view.showDataDiscover(list);
            }
        });
    }

    @Override
    public void getDataVoucher(int userId) {
        homeRepository.getVoucher(new HomeRepository.VoucherCallBack() {
            @Override
            public void listVoucher(List<HomeModel> listVoucher) {
                list = listVoucher;
                view.showDataVoucher(list, userId); // Đảm bảo gọi lại showDataVoucher với cả userId
            }
        });
    }


    @Override
    public void onMyVoucher(int userId, int voucherId) {
        homeRepository.getMyVoucher(userId, voucherId, new HomeRepository.CheckMyVoucherCallBack(){
            @Override
            public void checkMyVoucher(boolean checkMyVoucher) {
                if(checkMyVoucher){
                    view.notifVoucher(userId, checkMyVoucher);
                }else {
                    homeRepository.saveVoucher(userId, voucherId);
                    view.notifVoucher(userId, checkMyVoucher);
                }
            }
        });
    }
}
