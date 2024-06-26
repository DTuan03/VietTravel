package com.httt1.vietnamtravel.favorite.presenter;

import android.content.Context;

import com.httt1.vietnamtravel.favorite.model.FavoriteModel;
import com.httt1.vietnamtravel.favorite.model.FavoriteTourRepository;
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.List;

public class FavoritePresenter implements FavoriteContract.Presenter {
    private final FavoriteContract.View view;
    private List<FavoriteModel> list; // Instance variable to store the list

    private final FavoriteTourRepository favoriteTourRepository;

    public FavoritePresenter(FavoriteContract.View view, Context context) {
        this.view = view;
        this.favoriteTourRepository = new FavoriteTourRepository(); // Ensure initialization
    }

    public FavoriteTourRepository getFavoriteTourRepository() {
        return favoriteTourRepository;
    }

    @Override
    public void getDataFavoriteTour(int userId) {
        favoriteTourRepository.getFavoriteTours(userId, new FavoriteTourRepository.FavoriteTourCallBack() {
            @Override
            public void listFavoriteTour(List<FavoriteModel> listFavoriteTour) {
                list = listFavoriteTour;
                view.showDataFavoriteTour(list);
            }
        });
    }
}
