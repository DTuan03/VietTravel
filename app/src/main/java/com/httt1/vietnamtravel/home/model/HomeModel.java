package com.httt1.vietnamtravel.home.model;

public class HomeModel {
    private int userId;
    private String tourId;
    private String urlImg;
    private String nameTour;
    private int isFavorite;
    private int price;
    private int voucherId;
    private float avgrStar;

    //recomend
    public HomeModel(String urlImg, String nameTour, float avgrStar, int price, int isFavorite) {
        this.urlImg = urlImg;
        this.nameTour = nameTour;
        this.avgrStar = avgrStar;
        this.price = price;
        this.isFavorite = isFavorite;
    }

    //combo
    public HomeModel(String TourId, String urlImg, String nameTour, int price, int isFavorite) {
        this.tourId = TourId;
        this.urlImg = urlImg;
        this.nameTour = nameTour;
        this.price = price;
        this.isFavorite = isFavorite;
    }

    //Voucher
    public HomeModel(int voucherId, String urlImg){
        this.voucherId = voucherId;
        this.urlImg = urlImg;
    }

    public String geturlImg() {
        return urlImg;
    }

    public void seturlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getnameTour() {
        return nameTour;
    }

    public void setnameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public float getavgrStar() {
        return avgrStar;
    }
    public void setavgrStar(float avgrStar) {
        this.avgrStar = avgrStar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String gettourId() {
        return tourId;
    }

    public void settourId(String tourId) {
        this.tourId = tourId;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

}
