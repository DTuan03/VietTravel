package com.httt.viettravel.Model;

public class Image {
    private String idImg;
    private String imgResource;

    public Image(String idImg, String imgResource) {
        this.idImg = idImg;
        this.imgResource = imgResource;
    }

    public String getIdImg() {
        return idImg;
    }

    public void setIdImg(String idImg) {
        this.idImg = idImg;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void setImgResource(String imgResource) {
        this.imgResource = imgResource;
    }
}
