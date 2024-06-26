package com.httt1.vietnamtravel.bookTour.model;

import java.util.Date;

public class BookTourModel {
    private String name, phone, email, paymentMethod;
    private int numberBook, idVoucher, idUser, idTour, total;
    private Date startDay, endDay;

    public BookTourModel(int idTour, int idUser, String name, String phone, String email, Date startDay, Date endDay,int numberBook, int idVoucher, String paymentMethod,int total) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.numberBook = numberBook;
        this.idVoucher = idVoucher;
        this.idUser = idUser;
        this.idTour = idTour;
        this.startDay = startDay;
        this.endDay = endDay;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
}
