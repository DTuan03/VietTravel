package com.httt.viettravel.Model;

import java.util.List;

public class Feedback {
    private String idFeedback;
    private String idBookedTour;
    private String descriptionFeedback;
    private int rating;
    private String dateOfFeedback;
    private String timeOfFeedback;
    private String userName;
    private String nameTour;
    private List<String> imageUrls;
    private String imgMainResource;

    public Feedback(String idFeedback, String idBookedTour, String descriptionFeedback, int rating, String dateOfFeedback, String timeOfFeedback, String userName, String nameTour, List<String> imageUrls, String imgMainResource) {
        this.idFeedback = idFeedback;
        this.idBookedTour = idBookedTour;
        this.descriptionFeedback = descriptionFeedback;
        this.rating = rating;
        this.dateOfFeedback = dateOfFeedback;
        this.timeOfFeedback = timeOfFeedback;
        this.userName = userName;
        this.nameTour = nameTour;
        this.imageUrls = imageUrls;
        this.imgMainResource = imgMainResource;
    }

    // Getters and setters
    public String getIdFeedback() {
        return idFeedback;
    }

    public String getIdBookedTour() {
        return idBookedTour;
    }

    public String getDescriptionFeedback() {
        return descriptionFeedback;
    }

    public int getRating() {
        return rating;
    }

    public String getDateOfFeedback() {
        return dateOfFeedback;
    }

    public String getTimeOfFeedback() {
        return timeOfFeedback;
    }

    public String getUserName() {
        return userName;
    }

    public String getNameTour() {
        return nameTour;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public String getImgMainResource() {
        return imgMainResource;
    }
}
