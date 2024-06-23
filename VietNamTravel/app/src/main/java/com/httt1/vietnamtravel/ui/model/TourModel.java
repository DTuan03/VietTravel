package com.httt1.vietnamtravel.ui.model;

public class TourModel {
    private int userId;
    private String tourId;
    private String urlImg;
    private String nameTour;
    private boolean isFavorite;
    private int price;
    private float avgrStar;

    public TourModel(int userId, String tourId) {
        this.userId = userId;
        this.tourId = tourId;
    }
    //recomend
    public TourModel(String urlImg, String nameTour, float avgrStar, int price, boolean isFavorite) {
        this.urlImg = urlImg;
        this.nameTour = nameTour;
        this.avgrStar = avgrStar;
        this.price = price;
        this.isFavorite = false;
    }

    //combo
    public TourModel(String TourId, String urlImg, String nameTour, int price, boolean isFavorite) {
        this.tourId = TourId;
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

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
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

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
        // Có thể thực hiện các hoạt động liên quan khi trạng thái yêu thích thay đổi,
        // ví dụ như cập nhật giao diện người dùng
        if (isFavorite) {
            // Nếu đánh dấu là yêu thích
            System.out.println("Đánh dấu tour " + nameTour + " là yêu thích.");
        } else {
            // Nếu bỏ đánh dấu là yêu thích
            System.out.println("Bỏ đánh dấu tour " + nameTour + " là yêu thích.");
        }
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
