package com.httt.viettravel.Model;

public class Guide {
    private int idResouce;
    private String title;

    public Guide(int idResouce, String title) {
        this.idResouce = idResouce;
        this.title = title;
    }

    public int getIdResouce() {
        return idResouce;
    }

    public void setIdResouce(int idResouce) {
        this.idResouce = idResouce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
