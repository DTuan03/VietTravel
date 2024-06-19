package com.httt.viettravel.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
public class Tour {
    private String idTour;
    private String typeTour;
    private String nameTour;
    private String descriptionTour;
    private int numberDay;
    private float priceTour;
    private float total;
    private boolean favTour;
    private String hotel;
    private String vehicle;
    private boolean propose;
    private boolean notMissed;

//    public Tour(String idTour, String nameTour, int numberDay, float priceTour) {
//        this.idTour = idTour;
//        this.nameTour = nameTour;
//        this.numberDay = numberDay;
//        this.priceTour = priceTour;
//    }

    public Tour(String idTour, String typeTour, String nameTour, String descriptionTour, int numberDay, float priceTour,float total, boolean favTour, String hotel, String vehicle, boolean propose, boolean notMissed) {
        this.idTour = idTour;
        this.typeTour = typeTour;
        this.nameTour = nameTour;
        this.descriptionTour = descriptionTour;
        this.numberDay = numberDay;
        this.priceTour = priceTour;
        this.total = total;
        this.favTour = favTour;
        this.hotel = hotel;
        this.vehicle = vehicle;
        this.propose = propose;
        this.notMissed = notMissed;
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

    public boolean isFavTour() {
        return favTour;
    }

    public void setFavTour(boolean favTour) {
        this.favTour = favTour;
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

    public boolean isPropose() {
        return propose;
    }

    public void setPropose(boolean propose) {
        this.propose = propose;
    }

    public boolean isNotMissed() {
        return notMissed;
    }

    public void setNotMissed(boolean notMissed) {
        this.notMissed = notMissed;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

