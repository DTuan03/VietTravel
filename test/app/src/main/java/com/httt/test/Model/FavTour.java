package com.httt.test.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavTour {
    public static Map<Tour, Integer> tourMap = new HashMap<>();

    public FavTour() {
    }

    public void addFavTour(Tour tour) {
        int quantity = tourMap.getOrDefault(tour, 0);
        if (quantity < 50) {
            tourMap.put(tour, quantity + 1);
        }
    }

    public void removeFavTour(Tour tour) {
        int quantity = tourMap.getOrDefault(tour, 0);
        if (quantity > 0) {
            tourMap.remove(tour);
        }
    }

    public int getQuantity(Tour tour) {
        return tourMap.getOrDefault(tour, 0);
    }

    public List<Tour> getFavTours() {
        return new ArrayList<>(tourMap.keySet());
    }

}
