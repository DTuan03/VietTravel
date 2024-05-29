package com.httt.test.Model;

import android.net.Uri;
import android.widget.TextView;

import java.io.Serializable;

public class Tour implements Serializable {

    public String tv_name_tour;
    public String tv_description;
    public String price;
    public int tv_fav;
    public int img_tour;

    public Tour(String tv_name_tour, String tv_description, String price, int tv_fav, int img_tour) {
        this.tv_name_tour = tv_name_tour;
        this.tv_description = tv_description;
        this.price = price;
        this.tv_fav = tv_fav;
        this.img_tour = img_tour;
    }

    public String getTv_name_tour() {
        return tv_name_tour;
    }

    public void setTv_name_tour(String tv_name_tour) {
        this.tv_name_tour = tv_name_tour;
    }

    public String getTv_description() {
        return tv_description;
    }

    public void setTv_description(String tv_description) {
        this.tv_description = tv_description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getTv_fav() {
        return tv_fav;
    }

    public void setTv_fav(int tv_fav) {
        this.tv_fav = tv_fav;
    }

    public int getImg_tour() {
        return img_tour;
    }

    public void setImg_tour(int img_tour) {
        this.img_tour = img_tour;
    }
}

