package com.httt.viettravel.Model;

public class Feedback {
    private String idFeedback;
    private String idBookedTour;
    private String descriptionFeedback;
    private int rating;
    private String dateOfFeedback;
    private String timeOfFeedback;
    private String imgMainResource; // Thêm thuộc tính này
    private String UserName;
    private String NameTour;

    // Constructor, getters, and setters

    public Feedback(String idFeedback, String idBookedTour, String descriptionFeedback, int rating, String dateOfFeedback, String timeOfFeedback, String imgMainResource, String UserName, String NameTour) {
        this.idFeedback = idFeedback;
        this.idBookedTour = idBookedTour;
        this.descriptionFeedback = descriptionFeedback;
        this.rating = rating;
        this.dateOfFeedback = dateOfFeedback;
        this.timeOfFeedback = timeOfFeedback;
        this.imgMainResource = imgMainResource;
        this.UserName = UserName;
        this.NameTour = NameTour;
    }

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

    public String getImgMainResource() {
        return imgMainResource;
    }

    public void setImgMainResource(String imgMainResource) {
        this.imgMainResource = imgMainResource;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getNameTour() {
        return NameTour;
    }

    public void setNameTour(String nameTour) {
        NameTour = nameTour;
    }
}
