package com.httt.viettravel.Model;

import java.util.List;

public class Tour {
    private int pic;

    private String day;
    private String location;
    private String price;

    public Tour(int pic, String day, String location, String price) {
        this.pic = pic;
        this.day = day;
        this.location = location;
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
