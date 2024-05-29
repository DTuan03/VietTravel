//package com.httt.test.Repository;
//
//import com.httt.test.Model.Tour;
//
//import java.util.ArrayList;
//
//public class TourRepository {
//    private static ArrayList<Tour> tourList = new ArrayList<>();
//
//    public TourRepository(ArrayList<Tour> lst) {
//        for (Tour p: lst){
//            this.tourList.add(p);
//        }
//    }
//    public TourRepository(){
//
//    }
//
//    public static ArrayList<Tour> getTourList() {
//        return tourList;
//    }
//
//    public static void setTourList(ArrayList<Tour> tourList) {
//        TourRepository.tourList = tourList;
//    }
//
//    public void addTour(Tour t){
//        this.tourList.add(t);
//    }
//
//    public static Tour getTour(Integer id_tour){
//        Tour result;
//        for ( Tour t : tourList) {
//            if (id_tour == t.getId_Tour())
//                return t;
//        }
//        return  null;
//    }
//}
