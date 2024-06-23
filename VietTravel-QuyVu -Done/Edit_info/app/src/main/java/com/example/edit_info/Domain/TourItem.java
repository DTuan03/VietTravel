package com.example.edit_info.Domain;

public class TourItem {
    private int pic;
    private String location;

    public TourItem(int pic, String location) {
        this.pic = pic;
        this.location = location;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
