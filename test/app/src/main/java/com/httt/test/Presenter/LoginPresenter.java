package com.httt.test.Presenter;

import com.httt.test.View.LoginView;

public class LoginPresenter {

    LoginView loginView;
    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        if (username.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("admin")) {
            loginView.loginSuccessful();
            loginView.goHome();
        } else {
            loginView.loginFail();
        }
    }

}
