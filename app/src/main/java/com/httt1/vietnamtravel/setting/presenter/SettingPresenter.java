package com.httt1.vietnamtravel.setting.presenter;

import com.httt1.vietnamtravel.setting.model.SettingRepository;

public class SettingPresenter implements SettingContract.Presenter{
    private final SettingContract.View view;
    private final SettingRepository repository;
    public SettingPresenter(SettingContract.View view){
        this.view = view;
        this.repository = new SettingRepository();
    }
    @Override
    public void setNameUser(int userId) {
        if(userId != 0){
            repository.getNameUser(userId, new SettingRepository.NameCallBack() {
                @Override
                public void getNameUser(String nameUser) {
                    view.setText(nameUser);
                }
            });
        }else{
            view.setText("Đăng ký/Đăng nhập");
            view.onRegis();
        }
    }

    @Override
    public void setClick(int userId) {
        if(userId != 0){
            view.onAccount();
            view.onReplacePass();
            view.onMyVoucher();
            view.onLogOut();
        }else{
            view.notifi();
        }
    }
}
