package com.httt.test.Repository;

import android.app.Application;
import android.content.Context;

import com.httt.test.DAO.TourDAO;
import com.httt.test.DatabaseRoom.TourDatabase;
import com.httt.test.Model.Tour;
import com.httt.test.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TourRepository {
    private static List<Tour> tourList = new ArrayList<>();
    Context context;
    public TourRepository(Context context) {
        this.context = context;

    }

    public static List<Tour> getTourList() {
        return tourList;
    }

    public static void setTourList(List<Tour> tourList) {
        TourRepository.tourList = tourList;
    }

    public int countNullTours() {
        if(tourList.isEmpty())
        {
            tourList = TourDatabase.getInstance(context).tourDAO().getListTour();
        }
        return tourList.size();
    }

    public List<Tour> initializeTours(Context context){
        if(countNullTours() == 0){
            List<Tour> tours = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                String name = "Tour " + i;
                String des = "Welcome to tour " + i;
                float price = random.nextFloat() * 1000;
                int resID = context.getResources().getIdentifier("img_"+ i % 6, "drawable", context.getPackageName());
                String imgUri = "android.resource://" + context.getPackageName() + "/" + resID;

                tours.add(new Tour(name, des, price, imgUri));
            }
//            tours.add(new Tour("Da Lat", "Traveling to Da Lat", 2000, R.drawable.baseline_bookmark_border_24, "R.drawable.img_0"));
//            tours.add(new Tour("Da Lat", "Traveling to Da Lat", 2000, R.drawable.baseline_bookmark_border_24, "R.drawable.img_0"));
//            tours.add(new Tour("Da Lat", "Traveling to Da Lat", 2000, R.drawable.baseline_bookmark_border_24, "R.drawable.img_0"));
//            tours.add(new Tour("Da Lat", "Traveling to Da Lat", 2000, R.drawable.baseline_bookmark_border_24, "R.drawable.img_0"));
//            tours.add(new Tour("Da Lat", "Traveling to Da Lat", 2000, R.drawable.baseline_bookmark_border_24, "R.drawable.img_0"));

            TourDatabase.getInstance(context).tourDAO().insertTours(tours);
        }
        return tourList;
    }
}
