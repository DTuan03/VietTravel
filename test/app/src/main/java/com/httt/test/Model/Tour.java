package com.httt.test.Model;

import android.net.Uri;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tour")
public class Tour implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id_tour;
    public int type;
    public String tv_name_tour;
    public String tv_description;
    public float price;
    public String img_tour;

    public Tour() {
    }

    public Tour(String tv_name_tour, String tv_description, float price, String img_tour) {
        this.tv_name_tour = tv_name_tour;
        this.tv_description = tv_description;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public String getImg_tour() {
        return img_tour;
    }

    public void setImg_tour(String img_tour) {
        this.img_tour = img_tour;
    }
}

