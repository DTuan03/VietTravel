package com.httt.viettravel.History.Unrated.Model;

import java.util.Date;

public class Tour {
    private String idTour;
    private String typeTour;
    private String nameTour;
    private String descriptionTour;
    private int numberDay;
    private int total;
    private Date startDay;
    private Date endDay;
    private String hotel;
    private String vehicle;
    private String idBookedTour;
    private String imgMainResource;

    public Tour(String idTour, String typeTour, String nameTour, String descriptionTour, int numberDay, int total, Date startDay, Date endDay, String hotel, String vehicle, String idBookedTour, String imgMainResource) {
        this.idTour = idTour;
        this.typeTour = typeTour;
        this.nameTour = nameTour;
        this.descriptionTour = descriptionTour;
        this.numberDay = numberDay;
        this.total = total;
        this.startDay = startDay;
        this.endDay = endDay;
        this.hotel = hotel;
        this.vehicle = vehicle;
        this.idBookedTour = idBookedTour;
        this.imgMainResource = imgMainResource;
    }

    // Getters and setters
    public String getIdTour() {
        return idTour;
    }

    public String getTypeTour() {
        return typeTour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public String getDescriptionTour() {
        return descriptionTour;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public int getTotal() {
        return total;
    }

    public Date getStartDay() {
        return startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public String getHotel() {
        return hotel;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getIdBookedTour() {
        return idBookedTour;
    }

    public String getImgMainResource() {
        return imgMainResource;
    }


}
