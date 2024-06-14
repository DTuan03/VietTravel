package com.httt.viettravel.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Tour  implements Parcelable{

    private  int pic;
    private String content, location, routine, time, price, vehicle, place, comment;
    private float rating;
    private String date;
    private String reviewTime;

    public Tour(int pic, String content, String location, String routine, String time, String price, String vehicle, String place, String comment, float rating, String date, String reviewTime) {
        this.pic = pic;
        this.content = content;
        this.location = location;
        this.routine = routine;
        this.time = time;
        this.price = price;
        this.vehicle = vehicle;
        this.place = place;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.reviewTime = reviewTime;
    }

    public Tour(int pic, String location, float rating, String comment, String date, String reviewTime) {
        this.pic = pic;
        this.location = location;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.reviewTime=reviewTime;
    }


    protected Tour(Parcel in) {
        pic = in.readInt();
        content = in.readString();
        location = in.readString();
        routine = in.readString();
        time = in.readString();
        price = in.readString();
        vehicle = in.readString();
        place = in.readString();
        comment = in.readString();
        rating = in.readFloat();
        date = in.readString();
        reviewTime = in.readString();
    }

    public static final Creator<Tour> CREATOR = new Creator<Tour>() {
        @Override
        public Tour createFromParcel(Parcel in) {
            return new Tour(in);
        }

        @Override
        public Tour[] newArray(int size) {
            return new Tour[size];
        }
    };

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(pic);
        dest.writeString(location);
        dest.writeFloat(rating);
        dest.writeString(comment);
        dest.writeString(date);
        dest.writeString(reviewTime);
    }
}
