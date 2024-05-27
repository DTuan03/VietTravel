package com.httt.viettravel.Model;

public class CommentTour {
    private  int pic;
    private String content;
    private String location;
    private String routine;
    private String time;
    private String price;
    private String vehicle;
    private String place;
    private String comment;

    public CommentTour(int pic, String content, String location, String routine, String time, String price, String vehicle, String place, String comment) {
        this.pic = pic;
        this.content = content;
        this.location = location;
        this.routine = routine;
        this.time = time;
        this.price = price;
        this.vehicle = vehicle;
        this.place = place;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoutine() {
        return routine;
    }

    public void setRoutine(String routine) {
        this.routine = routine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }



}
