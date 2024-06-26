package com.httt1.vietnamtravel.DetailTour.model;

import java.util.List;

public class DetailModel {

    private int userId;
    private int tourId;
    private String nameTour;
    private boolean isFavorite;
    private int price;
    private float avgrStar;
    private String description;
    private int numberDay;
    private String hotel;
    private String vehicle;
    private List<String> imageUrls;

    // detail
    public DetailModel(int tourId, String nameTour, boolean isFavorite, int price,
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
