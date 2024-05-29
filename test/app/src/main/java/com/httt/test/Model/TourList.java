//package com.httt.test.Model;
//
//import com.httt.test.Model.TourList;
//import com.httt.test.Repository.TourRepository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class TourList extends ArrayList<Tour> {
//    public static Map<Integer, Integer> tourList = new HashMap<>();
//    private Object keys[];
//
//    public TourRepository tourRepository = new TourRepository();
//
////    public void addTourFav(Tour tour) {
////        Integer quantity = tourList.getOrDefault(tour.getId_Tour(), 0);
////        if (quantity >= 10) return;
////        tourList.put(tour.getId_Tour(), quantity + 1);
////    }
//
//    public Tour getTourByFav(Integer pos) {
//        keys = tourList.keySet().toArray();
//        return TourRepository.getTour(Integer.parseInt(keys[pos].toString()));
//    }
//
//    public void removTour(Tour t) {
//        Integer quantity = tourList.getOrDefault(t.getId_Tour(), 0);
//        if (quantity <= 0) return;
//        tourList.put(t.getId_Tour(), quantity - 1);
//    }
//
//    public List<Tour> getAllTours() {
//        List<Tour> tours = new ArrayList<>();
//        for (Integer tourId : tourList.keySet()) {
//            Tour tour = TourRepository.getTour(tourId);
//            tours.add(tour);
//        }
//        return tours;
//    }
//}