package com.httt.test.Model;

import android.net.Uri;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tour")
public class Tour implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDTour")
    public int id_tour;
    @ColumnInfo(name = "TourType")
    public int type;
    @ColumnInfo(name = "NameOfTour")
    public String tv_name_tour;
    @ColumnInfo(name = "Rating")
    public float tv_rating;
    @ColumnInfo(name = "DescriptionOfTour")
    public String tv_description;
    @ColumnInfo(name = "Price")
    public float price;
    @ColumnInfo(name = "Image")
    public String img_tour;

    public Tour() {
    }

    public Tour(String tv_name_tour, float tv_rating, float price, String img_tour) {
        this.tv_name_tour = tv_name_tour;
        this.tv_rating = tv_rating;
        this.price = price;
        this.img_tour = img_tour;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getTv_rating() {
        return tv_rating;
    }

    public void setTv_rating(float tv_rating) {
        this.tv_rating = tv_rating;
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

