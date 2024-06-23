package com.httt.viettravel.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Tour {
    private String idTour;
    private String typeTour;
    private String nameTour;
    private String descriptionTour;
    private int numberDay;
    private float priceTour;
    private float total;
    private Date startDay;  // Thêm trường startDay
    private Date endDay;
    private String hotel;
    private String vehicle;
    private String idBookedTour;
    private String imgMainResource; // Thêm thuộc tính này


    public Tour(String idTour, String typeTour, String nameTour, String descriptionTour, int numberDay, float priceTour,float total, Date startDay, Date endDay , String hotel, String vehicle, String idBookedTour,String imgMainResource) {
        this.idTour = idTour;
        this.typeTour = typeTour;
        this.nameTour = nameTour;
        this.descriptionTour = descriptionTour;
        this.numberDay = numberDay;
        this.priceTour = priceTour;
        this.total = total;
        this.startDay = startDay;
        this.endDay = endDay;
        this.hotel = hotel;
        this.vehicle = vehicle;
        this.idBookedTour = idBookedTour;
        this.imgMainResource = imgMainResource;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public String getTypeTour() {
        return typeTour;
    }

    public void setTypeTour(String typeTour) {
        this.typeTour = typeTour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getDescriptionTour() {
        return descriptionTour;
    }

    public void setDescriptionTour(String descriptionTour) {
        this.descriptionTour = descriptionTour;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public float getPriceTour() {
        return priceTour;
    }

    public void setPriceTour(float priceTour) {
        this.priceTour = priceTour;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getIdBookedTour() {
        return idBookedTour;
    }

    public void setIdBookedTour(String idBookedTour) {
        this.idBookedTour = idBookedTour;
    }

    public String getImgMainResource() {
        return imgMainResource;
    }

    public void setImgMainResource(String imgMainResource) {
        this.imgMainResource = imgMainResource;
    }
}

