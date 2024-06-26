package com.httt1.vietnamtravel.myvoucher.presenter;

import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.myvoucher.model.MyVoucherModel;

import java.util.List;

public interface MyVoucherContract {
    interface View{
        void showDataMyVoucher(List<MyVoucherModel> list);
    }
    interface Presenter{
        void getDataMyVoucher(int userId);

    }
}
