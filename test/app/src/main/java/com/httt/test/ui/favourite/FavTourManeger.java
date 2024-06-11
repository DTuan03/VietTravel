package com.httt.test.ui.favourite;

import com.httt.test.Model.Tour;

import java.util.ArrayList;
import java.util.List;

public class FavTourManeger {
    private static FavTourManeger instance;
    private List<Tour> favoriteTours;
    private List<OnFavoriteTourChangedListener> listeners;

    private FavTourManeger() {
        favoriteTours = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public static FavTourManeger getInstance() {
        if (instance == null) {
            instance = new FavTourManeger();
        }
        return instance;
    }

    public void addFavoriteTour(Tour tour) {
        favoriteTours.add(tour);
        notifyFavoriteTourChanged();
    }

    public void removeFavoriteTour(Tour tour) {
        favoriteTours.remove(tour);
        notifyFavoriteTourChanged();
    }

    public List<Tour> getFavoriteTours() {
        return favoriteTours;
    }

    public void addOnFavoriteTourChangedListener(OnFavoriteTourChangedListener listener) {
        listeners.add(listener);
    }

    public void removeOnFavoriteTourChangedListener(OnFavoriteTourChangedListener listener) {
        listeners.remove(listener);
    }

    private void notifyFavoriteTourChanged() {
        for (OnFavoriteTourChangedListener listener : listeners) {
            listener.onFavoriteTourChanged();
        }
    }

    public interface OnFavoriteTourChangedListener {
        void onFavoriteTourChanged();
    }
}
