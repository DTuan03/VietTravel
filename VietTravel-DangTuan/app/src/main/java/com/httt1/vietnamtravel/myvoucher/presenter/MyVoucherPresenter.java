package com.httt1.vietnamtravel.myvoucher.presenter;

import com.httt1.vietnamtravel.myvoucher.model.MyVoucherModel;
import com.httt1.vietnamtravel.myvoucher.model.MyVoucherRepository;

import java.util.List;

public class MyVoucherPresenter implements MyVoucherContract.Presenter{
    private final MyVoucherContract.View view;
    private final MyVoucherRepository myVoucherRepository;
    private List<MyVoucherModel> list;

    public MyVoucherPresenter(MyVoucherContract.View view){
        this.view = view;
        this.myVoucherRepository = new MyVoucherRepository();
    }
    @Override
    public void getDataMyVoucher(int userId) {
        myVoucherRepository.getMyVoucher(userId, new MyVoucherRepository.MyVoucherCallBack() {
            @Override
            public void getListMyVoucher(List<MyVoucherModel> listMyVoucher) {
                list = listMyVoucher;
                view.showDataMyVoucher(list);
            }
        });
    }
}
