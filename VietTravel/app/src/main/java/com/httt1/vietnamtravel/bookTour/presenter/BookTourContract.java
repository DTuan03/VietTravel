package com.httt1.vietnamtravel.bookTour.presenter;

import java.util.ArrayList;
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
        int getTotal();
        void setDataVoucher(ArrayList<String> arrayList);
        void setPrice(String price);
    }
    interface Presenter{
        void total(int numberBook, int price);
        void totalAfterVoucher(int total);
        ArrayList<String>  setDataVoucher(int userId);
        void onBookTour(int userId, int idTour);
    }
}
