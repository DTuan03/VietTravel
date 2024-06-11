package com.httt.viettravel;


import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.method.PasswordTransformationMethod;
import android.widget.TextView;


public class RegistrationActivity extends AppCompatActivity {
    ImageView matAn1, matAn2;
    EditText matKhau, nhapLai;
    EditText tenDayDu, sdt;
    Button regis;

    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_registraion), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        clickImageView(matAn1,matKhau);
        clickImageView(matAn2,nhapLai);
        setButton();
    }

    private void init(){
        matAn1 = (ImageView) findViewById(R.id.activity_registration_iv_matan1);
        matAn2 = (ImageView) findViewById(R.id.activity_registration_iv_matan2);

        matKhau = (EditText) findViewById(R.id.activity_registration_ed_matkhau);
        nhapLai = (EditText) findViewById(R.id.activity_registration_ed_nhaplaimatkhau);

        tenDayDu = (EditText) findViewById(R.id.activity_registration_et_tendaydu);
        sdt = (EditText) findViewById(R.id.activity_registration_et_sdt);

        regis = (Button) findViewById(R.id.activity_registration_btn_dangky);

        error = (TextView) findViewById(R.id.activity_registraion_tv_error);
    }

    //an hien mat khau
    private void clickImageView(ImageView matAn, EditText matKhau){
        matAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getTag() == null || (int)v.getTag() == R.mipmap.ic_launcher_eye_hidden_adaptive_fore){
                    matAn.setImageResource(R.mipmap.ic_launcher_eye_adaptive_fore);
                    v.setTag(R.mipmap.ic_launcher_eye_adaptive_fore);
                    matKhau.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }else{
                    matAn.setImageResource(R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                    v.setTag(R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                    matKhau.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                matKhau.requestFocus();
                matKhau.clearFocus();
            }
        });
    }

    //doi mau button
    private boolean isEmpty(EditText et){
        String str = et.getText().toString();
        return (str.isEmpty());
    }
    @SuppressLint("ResourceAsColor")
    private void ShowButton() {
        if (isEmpty(tenDayDu) || isEmpty(sdt) || isEmpty(matKhau) || isEmpty(nhapLai)) {
            regis.setEnabled(false);
            regis.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.regis_before)));
        }
        else{
            if(kiemTraMk()){
                regis.setEnabled(true);
                regis.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.regis_after)));
            }else{
                regis.setEnabled(false);
                regis.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.regis_before)));
            }

        }
    }
    private boolean kiemTraMk(){
        String matKhauText = matKhau.getText().toString();
        String nhapLaiText = nhapLai.getText().toString();
        if(!matKhauText.equals(nhapLaiText)){
            error.setText("Mật khẩu không khớp!");
            return false;
        }
        else{
            error.setText(null);
            return true;
        }
    }


    private void setButton(){
        tenDayDu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShowButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShowButton();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        matKhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShowButton();
                kiemTraMk();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        nhapLai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShowButton();
                kiemTraMk();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

}