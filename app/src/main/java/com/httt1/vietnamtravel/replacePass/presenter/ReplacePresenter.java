package com.httt1.vietnamtravel.replacePass.presenter;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.httt1.vietnamtravel.R;

import com.httt1.vietnamtravel.replacePass.model.RepalceRepository;

public class ReplacePresenter implements ReplaceContract.Presenter{
    private final ReplaceContract.View view;
    private final RepalceRepository repalceRepository;
    public ReplacePresenter(ReplaceContract.View view){
        this.view = view;
        this.repalceRepository = new RepalceRepository();
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
    public void onClickReplace(int userId) {
        repalceRepository.CheckPass(userId, new RepalceRepository.CheckPassOldCallBack() {
            @Override
            public void onCheckPassOld(String pass) {
                if (pass.equals(view.getPassOld()) && view.getPassCf().equals(view.getPassNew()) && !view.getPassNew().isEmpty() ){
                    repalceRepository.updatePass(view.getPassNew(), userId);
                    view.forcus();
                }else{
                    view.notifi();
                }
            }});
    }
}
