//package com.httt.test.Model;
//
//import com.httt.test.Model.VoucherList;
//import com.httt.test.Repository.TourRepository;
//import com.httt.test.Repository.VoucherRepository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class VoucherList extends ArrayList<Tour> {
//    public static Map<Integer, Integer> voucherList = new HashMap<>();
//    private Object keys[];
//
//    public VoucherRepository voucherRepository = new VoucherRepository();
//
//    public void addVoucherFav(Voucher voucher) {
//        Integer quantity = voucherList.getOrDefault(voucher.getId_Tour(), 0);
//        if (quantity >= 10) return;
//        voucherList.put(voucher.getId_Tour(), quantity + 1);
//    }
//
//    public Voucher getVoucherByFav(Integer pos) {
//        keys = voucherList.keySet().toArray();
//        return voucherRepository.getVoucher(Integer.parseInt(keys[pos].toString()));
//    }
//
//    public void removVoucher(Voucher v) {
//        Integer quantity = voucherList.getOrDefault(v.getId_Tour(), 0);
//        if (quantity <= 0) return;
//        voucherList.put(v.getId_Tour(), quantity - 1);
//    }
//
//    public List<Tour> getAllTours() {
//        List<Tour> tours = new ArrayList<>();
//        for (Integer tourId : voucherList.keySet()) {
//            Tour tour = TourRepository.getTour(tourId);
//            tours.add(tour);
//        }
//        return tours;
//    }
//
//}