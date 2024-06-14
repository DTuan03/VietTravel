package com.httt.viettravel.Model;

public class Favorite {
    private int ResourcImg;
    private String title;
    private String avgStar;
    private String price;

    public Favorite(int resourcImg, String title, String avgStar, String price) {
        ResourcImg = resourcImg;
        this.title = title;
        this.avgStar = avgStar;
        this.price = price;
    }

    public int getResourcImg() {
        return ResourcImg;
    }

    public void setResourcImg(int resourcImg) {
        ResourcImg = resourcImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvgStar() {
        return avgStar;
    }

    public void setAvgStar(String avgStar) {
        this.avgStar = avgStar;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
