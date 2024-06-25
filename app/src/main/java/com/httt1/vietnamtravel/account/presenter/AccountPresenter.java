package com.httt1.vietnamtravel.account.presenter;

import com.httt1.vietnamtravel.account.model.AccountModel;
import com.httt1.vietnamtravel.account.model.AccountRepository;
import com.httt1.vietnamtravel.home.presenter.HomeContract;

public class AccountPresenter implements AccountContract.Presenter{
    private AccountContract.View view;
    private final AccountRepository accountRepository;
    public AccountPresenter(AccountContract.View view){
        this.view = view;
        this.accountRepository = new AccountRepository();
    }
    @Override
    public void getInfo(int userId) {
        accountRepository.getInfoUser(userId, new AccountRepository.InfoUserCallBack() {
            @Override
            public void infoUser(AccountModel accountModel) {
                String userName = accountModel.getName();
                String userDate = accountModel.getDate();
                String userPhone = accountModel.getPhone();
                String userEmail = accountModel.getEmail();
                String userAddress = accountModel.getAddress();
                view.setUserName(userName);

                view.setDate(userDate != null ? userDate : "Chưa có");

                view.setPhone(userPhone);

                view.setEmail(userEmail != null ? userEmail : "Chưa có");

                view.setAddress(userAddress != null ? userAddress : "Chưa có");
            }
        });
    }
}
