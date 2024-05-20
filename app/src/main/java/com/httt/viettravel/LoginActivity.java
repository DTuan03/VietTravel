package com.httt.viettravel;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText sdt, matKhau;
    ImageView matAn;

    TextView qmk, dangKy;

    Button dangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setupTextWatchers();
        showPassWord();
        setDangKy();
    }

    private void init(){
        sdt = (EditText) findViewById(R.id.activity_login_et_sdt);
        matKhau = (EditText) findViewById(R.id.activity_login_et_mk);
        matAn = (ImageView) findViewById(R.id.actvity_login_iv_matAn);
        qmk = (TextView) findViewById(R.id.activity_login_tv_qmk);
        dangKy = (TextView) findViewById(R.id.activity_login_tv_dangky);
        dangNhap = (Button) findViewById(R.id.activity_login_btn_dang_nhap);
    }
    private boolean isEmpty(EditText et){
        String str = et.getText().toString();
        return (str.isEmpty());
    }
    private void setButton(){
        if(isEmpty(sdt) || isEmpty(matKhau)){
            dangNhap.setEnabled(false);
            dangNhap.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.regis_before)));
        }else{
            dangNhap.setEnabled(true);
            dangNhap.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.regis_after)));
        }
    }
    private void setupTextWatchers(){
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("tag","Test");
                setButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        sdt.addTextChangedListener(textWatcher);
        matKhau.addTextChangedListener(textWatcher);
    }

    private void showPassWord(){
        matAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("TAG", "Tag hidden: " + R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                if(v.getTag() == null || (int)v.getTag() == R.mipmap.ic_launcher_eye_hidden_adaptive_fore){
                    //    Log.d("RegistrationActivity", "Hien thi");
                    matAn.setImageResource(R.mipmap.ic_launcher_eye_adaptive_fore);
                    v.setTag(R.mipmap.ic_launcher_eye_adaptive_fore);
                    matKhau.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }else{
                    //    Log.d("RegistrationActivity", "An");
                    matAn.setImageResource(R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                    v.setTag(R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                    matKhau.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                matKhau.requestFocus();
                matKhau.clearFocus();
            }
        });
    }

    private void setDangKy(){
        dangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}