package com.httt.viettravel.Model;

public class Recommend {
    private int resourceId;
    private String title;
    private String numberStar;
    private String price;

    public Recommend(int resourceId, String title, String numberStar, String price) {
        this.resourceId = resourceId;
        this.title = title;
        this.numberStar = numberStar;
        this.price = price;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(String numberStar) {
        this.numberStar = numberStar;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
