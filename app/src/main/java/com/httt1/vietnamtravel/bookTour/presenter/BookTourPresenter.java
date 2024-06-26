package com.httt1.vietnamtravel.bookTour.presenter;

import android.content.Context;

import com.httt1.vietnamtravel.bookTour.model.BookTourModel;
import com.httt1.vietnamtravel.bookTour.model.BookTourRepository;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.httt1.vietnamtravel.home.presenter.HomeContract;

import java.util.List;

public class BookTourPresenter implements BookTourContract.Presenter{
    private final BookTourContract.View view;
    private final BookTourRepository bookTourRepository;
    private List<BookTourModel> list; // Biến instance để lưu trữ danh sách

    public BookTourPresenter(BookTourContract.View view){
        this.view = view;
        this.bookTourRepository = new BookTourRepository();
    }
    @Override
    public void setDataVoucher(int userId) {

    }

    @Override
    public void onBookTour(int userId, int idTour) {
        list = new BookTourModel(idTour, userId, view.getName(), view.getPhone(), view.getPhone(), view.getEmail(), view.getStarDay(), view.getEndDay(), view.getNumberBook(),view.getVoucher(), view.getPayMendMethod());
    }
}
