//package com.httt.test.Repository;
//
//import com.httt.test.Model.Voucher;
//
//import java.util.ArrayList;
//
//public class VoucherRepository {
//    private static ArrayList<Voucher> voucherList = new ArrayList<>();
//
//    public VoucherRepository(ArrayList<Voucher> lst) {
//        for (Voucher p: lst){
//            this.voucherList.add(p);
//        }
//    }
//    public VoucherRepository(){
//
//    }
//
//    public static ArrayList<Voucher> getVoucherList() {
//        return voucherList;
//    }
//
//    public static void setVoucherList(ArrayList<Voucher> voucherList) {
//        VoucherRepository.voucherList = voucherList;
//    }
//
//    public void addVoucher(Voucher v){
//        this.voucherList.add(v);
//    }
//
//    public Voucher getVoucher(Integer id_tour){
//        Voucher result;
//        for ( Voucher v : voucherList) {
//            if (id_tour == v.getId_Tour())
//                return v;
//        }
//        return  null;
//    }
//}
