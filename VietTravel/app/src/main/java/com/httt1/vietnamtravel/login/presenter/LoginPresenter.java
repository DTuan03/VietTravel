package com.httt1.vietnamtravel.login.presenter;

import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Context;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.login.model.LoginModel;
import com.httt1.vietnamtravel.login.model.LoginRepository;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    private final LoginRepository loginRepository;
    private final SharedPrefsHelper sharedPrefsHelper;
    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.loginRepository = new LoginRepository();
        this.sharedPrefsHelper = new SharedPrefsHelper(context);
    }

    @Override
    public void onEyePassClicked(ImageView eye, EditText pass) {
        if (eye.getTag() == null || (int)eye.getTag() == R.mipmap.icon_eye_hidden){
            eye.setImageResource(R.mipmap.activity_regis_icon_eye_show);
            eye.setTag(R.mipmap.activity_regis_icon_eye_show);
            pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            eye.setImageResource(R.mipmap.icon_eye_hidden);
            eye.setTag(R.mipmap.icon_eye_hidden);
            pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        pass.requestFocus();
        pass.clearFocus();
    }

    @Override
    public boolean onTextChanged() {
        if (isEmpty(view.getPhone()) || isEmpty(view.getPass()) ){
            boolean isVaild = false;
            view.enableLoginButton(isVaild);
            view.setLoginButtonColor(R.color.regis_before);
            return false;
        }else{
            boolean isVaild = true;
            view.enableLoginButton(isVaild);
            view.setLoginButtonColor(R.color.regis_after);
            return true;
        }
    }

    @Override
    public boolean isEmpty(String string) {
        return (string.isEmpty());
    }

    @Override
    public void onClickLogin() {
        if (onTextChanged()){
            LoginModel user = new LoginModel(view.getPhone(), view.getPass());
            loginRepository.login(user, new LoginRepository.LoginCallBack() {
                @Override
                public void checkUser(boolean success) {
                    if (success){
                        LoginModel user = new LoginModel(view.getPhone());
                        loginRepository.getUserId(user, new LoginRepository.UserIdCallBack() {
                            @Override
                            public void getUserId(int value) {
                                sharedPrefsHelper.putInt("UserId", value);
                            }
                        });
                            view.toMainActivity();
                    }else{
                        view.checkUser();
                    }
                }
            });
        }
    }
}
