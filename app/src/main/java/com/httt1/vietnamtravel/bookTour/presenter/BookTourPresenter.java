package com.httt1.vietnamtravel.bookTour.presenter;

import android.content.Context;

import com.httt1.vietnamtravel.bookTour.model.BookTourModel;
import com.httt1.vietnamtravel.bookTour.model.BookTourRepository;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.httt1.vietnamtravel.home.presenter.HomeContract;

import java.util.ArrayList;
import java.util.List;

public class BookTourPresenter implements BookTourContract.Presenter{
    private final BookTourContract.View view;
    private final BookTourRepository bookTourRepository;
    private List<BookTourModel> list; // Biến instance để lưu trữ danh sách
    private ArrayList<String> arrayList;
    private int totalInt;
    private int idVoucher;

    public BookTourPresenter(BookTourContract.View view){
        this.view = view;
        this.bookTourRepository = new BookTourRepository();
    }


    @Override
    public void total(int numberBook, int price) {
        totalInt = numberBook * price;
        String totalStr = String.valueOf(totalInt);
        view.setPrice(totalStr);
    }

    @Override
    public void totalAfterVoucher(int total) {
        bookTourRepository.getIdVoucher(view.getVoucher(), new BookTourRepository.IdVouherCallBack() {
            @Override
            public void getVoucher(ArrayList<Integer> voucher) {
                int totalEnd = (int) (total * (1 - (voucher.get(1) / 100.0)));
                String totalStr = String.valueOf(totalEnd);
                view.setPrice(totalStr);
            }
        });
    }

    @Override
    public ArrayList<String> setDataVoucher(int userId) {
        bookTourRepository.getVoucher(userId, totalInt,new BookTourRepository.ListVouherCallBack() {
            @Override
            public void getListVoucher(ArrayList<String> array) {
                arrayList = array;
            }
        });
        return  arrayList;
    }



    @Override
    public void onBookTour(int userId, int idTour) {
        bookTourRepository.getIdVoucher(view.getVoucher(), new BookTourRepository.IdVouherCallBack() {
            @Override
            public void getVoucher(ArrayList<Integer> voucher) {
                idVoucher = voucher.get(0);
            }
        });
        BookTourModel bookTourModel = new BookTourModel(idTour, userId, view.getName(), view.getPhone(), view.getEmail(), view.getStarDay(), view.getEndDay(), view.getNumberBook(),idVoucher, view.getPayMendMethod(), view.getTotal());

    }
}
