package com.httt.test.Repository;

import android.content.Context;

import com.httt.test.DatabaseRoom.VoucherDatabase;
import com.httt.test.Model.Tour;
import com.httt.test.Model.Voucher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VoucherRepository {
    private static List<Voucher> voucherList = new ArrayList<>();
    Context context;
    public VoucherRepository(Context context) {
        this.context = context;

    }

    public static List<Voucher> getVoucherList() {
        return voucherList;
    }

    public static void setVoucherList(List<Voucher> voucherList) {
        VoucherRepository.voucherList = voucherList;
    }

    public int countNullTours() {
        if(voucherList.isEmpty())
        {
            voucherList = VoucherDatabase.getInstance(context).voucherDAO().getListVoucher();
        }
        return voucherList.size();
    }

    public List<Voucher> initializeVouchers(Context context){
        if(countNullTours() == 0){
            List<Voucher> vouchers = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                String name = "Giảm giá 5%";
                String des = "Giảm 5% cho tour từ 2tr\nThời gian sử dụng: 1 ngày";
                int resID = context.getResources().getIdentifier("logo", "drawable", context.getPackageName());
                String imgUri = "android.resource://" + context.getPackageName() + "/" + resID;

                vouchers.add(new Voucher(imgUri, name, des));
            }

            VoucherDatabase.getInstance(context).voucherDAO().insertVouchers(vouchers);
        }
        return voucherList;
    }
}
