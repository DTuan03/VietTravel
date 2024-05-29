package com.httt.test.ui.favourite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Set;

import com.httt.test.Model.FavouriteTour;
public class FavouriteViewModel extends ViewModel {

    private final MutableLiveData<Set<Integer>> favoriteTours;

    public FavouriteViewModel() {
        favoriteTours = new MutableLiveData<>();
        loadFavorites();
    }

    public LiveData<Set<Integer>> getFavoriteTours() {
        return favoriteTours;
    }

    public void loadFavorites() {
        favoriteTours.setValue(FavouriteTour.getFavoriteTours());
    }
}
