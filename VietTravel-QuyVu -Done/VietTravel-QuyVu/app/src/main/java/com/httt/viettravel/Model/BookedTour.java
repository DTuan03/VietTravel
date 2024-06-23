package com.httt.viettravel.Model;

import java.util.Date;

public class BookedTour {
    private String idBookedTour;
    private String idTour;
    private String idUser;
    private Date startDay;
    private Date endDay;
    private int numberMember;
    private String idVoucher;
    private boolean payment;
    private String paymentMethod;
    private float total;
    private String phoneBooked;
    private String emailBooked;
    private String nameBooked;


    public BookedTour(String idBookedTour, String idTour, String idUser, Date startDay, Date endDay, int numberMember, String idVoucher, boolean payment, String paymentMethod, float total, String phoneBooked, String emailBooked, String nameBooked) {
        this.idBookedTour = idBookedTour;
        this.idTour = idTour;
        this.idUser = idUser;
        this.startDay = startDay;
        this.endDay = endDay;
        this.numberMember = numberMember;
        this.idVoucher = idVoucher;
        this.payment = payment;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.phoneBooked = phoneBooked;
        this.emailBooked = emailBooked;
        this.nameBooked = nameBooked;
    }

    public String getIdBookedTour() {
        return idBookedTour;
    }

    public void setIdBookedTour(String idBookedTour) {
        this.idBookedTour = idBookedTour;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public int getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(int numberMember) {
        this.numberMember = numberMember;
    }

    public String getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(String idVoucher) {
        this.idVoucher = idVoucher;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPhoneBooked() {
        return phoneBooked;
    }

    public void setPhoneBooked(String phoneBooked) {
        this.phoneBooked = phoneBooked;
    }

    public String getEmailBooked() {
        return emailBooked;
    }

    public void setEmailBooked(String emailBooked) {
        this.emailBooked = emailBooked;
    }

    public String getNameBooked() {
        return nameBooked;
    }

    public void setNameBooked(String nameBooked) {
        this.nameBooked = nameBooked;
    }
}
