package com.httt1.vietnamtravel.home.model;

import java.util.List;

public class HomeModel {

    private int userId;
    private int tourId;
    private String urlImg;
    private String nameTour;
    private boolean isFavorite;
    private int price;
    private float avgrStar;
    private String description;
    private int numberDay;
    private String hotel;
    private String vehicle;
    private int voucherId;
    private List<String> imageUrls;

    public HomeModel(int userId, int tourId) {
        this.userId = userId;
        this.tourId = tourId;
    }

//    Book tour
    public HomeModel(int tourId, String urlImg, String nameTour, int price) {
        this.tourId = tourId;
        this.urlImg = urlImg;
        this.nameTour = nameTour;
        this.price = price;
//        this.numberDay = numberDay;
    }

    // detail
    public HomeModel(int tourId, String nameTour, boolean isFavorite, int price,
                     String description, int numberDay, String hotel, String vehicle, List<String> imageUrls) {
        this.tourId = tourId;
        this.nameTour = nameTour;
        this.isFavorite = isFavorite;
        this.price = price;
        this.description = description;
        this.numberDay = numberDay;
        this.hotel = hotel;
        this.vehicle = vehicle;
        this.imageUrls = imageUrls;
    }

    //discover
    public HomeModel(int tourId, String urlImg, String nameTour, boolean isFavorite, int price, float avgrStar) {
        this.tourId = tourId;
        this.urlImg = urlImg;
        this.nameTour = nameTour;
        this.isFavorite = isFavorite;
        this.price = price;
        this.avgrStar = avgrStar;
    }

    //combo
    public HomeModel(int tourId, String urlImg, String nameTour, int price, boolean isFavorite) {
        this.tourId = tourId;
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

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
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


    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
