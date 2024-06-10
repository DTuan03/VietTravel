package com.httt.viettravel.Model;

import android.widget.ImageView;

public class Combo {
    private int resourceId;
    private String title;

    private String price;

    public Combo(int resourceId, String title, String price) {
        this.resourceId = resourceId;
        this.title = title;
        this.price = price;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
