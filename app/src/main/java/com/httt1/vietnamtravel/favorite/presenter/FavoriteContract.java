package com.httt1.vietnamtravel.favorite.presenter;

import com.httt1.vietnamtravel.favorite.model.FavoriteModel;

import java.util.List;

public interface FavoriteContract {

    interface View{
        void showDataFavoriteTour(List<FavoriteModel> list);
    }

    interface Presenter{
        void getDataFavoriteTour(int userId);
    }
}
