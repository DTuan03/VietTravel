package com.httt1.vietnamtravel.favorite.model;

import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.List;

public class FavoriteModel {
    private int userId;
    private int tourId;
    private String urlImg;
    private String nameTour;
    private boolean isFavorite;
    private int price;
    private float avgrStar;

    public FavoriteModel(int tourId, String urlImg, String nameTour, int price, boolean isFavorite) {
        this.tourId = tourId;
        this.urlImg = urlImg;
        this.nameTour = nameTour;
        this.price = price;
        this.isFavorite = isFavorite;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getAvgrStar() {
        return avgrStar;
    }

    public void setAvgrStar(float avgrStar) {
        this.avgrStar = avgrStar;
    }
}
