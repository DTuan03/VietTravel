package com.httt1.vietnamtravel.myvoucher.model;

public class MyVoucherModel {
    private String imgUrl, title, desdrip;

    public MyVoucherModel(String imgUrl, String title, String desdrip) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.desdrip = desdrip;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesdrip() {
        return desdrip;
    }

    public void setDesdrip(String desdrip) {
        this.desdrip = desdrip;
    }
}
