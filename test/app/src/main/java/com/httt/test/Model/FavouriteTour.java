package com.httt.test.Model;

import java.util.HashSet;
import java.util.Set;

public class FavouriteTour {
    private static Set<Integer> favoriteTours = new HashSet<>();

    // Thêm tour vào danh sách yêu thích
    public static void addTourToFavorites(int tourId) {
        favoriteTours.add(tourId);
    }

    // Xóa tour khỏi danh sách yêu thích
    public static void removeTourFromFavorites(int tourId) {
        favoriteTours.remove(tourId);
    }

    // Kiểm tra xem tour có trong danh sách yêu thích hay không
    public static boolean isTourFavorite(int tourId) {
        return favoriteTours.contains(tourId);
    }

    // Lấy danh sách các tour yêu thích
    public static Set<Integer> getFavoriteTours() {
        return favoriteTours;
    }
}
