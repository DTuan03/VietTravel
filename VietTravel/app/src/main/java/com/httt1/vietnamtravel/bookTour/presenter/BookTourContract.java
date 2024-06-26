package com.httt1.vietnamtravel.bookTour.presenter;

import java.util.Date;

public interface BookTourContract {
    interface View{
        String getName();
        String getPhone();
        String getEmail();
        Date getStarDay();
        Date getEndDay();
        int getNumberBook();
        String getVoucher();
        String getPayMendMethod();
    }
    interface Presenter{
        void setDataVoucher(int userId);
        void onBookTour(int userId, int idTour);
    }
}
