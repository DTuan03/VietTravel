package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
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

public class ReplaceActivity extends AppCompatActivity {

    private ImageView imgBack;
    private ImageView imgEyeHiddenPresent, imgEyeHiddenNew, imgEyeHiddenCf;
    private EditText etPassPresent, etPassNew, etPassCf;
    private TextView etNotify;
    private Button btnUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_replace);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setImgBack();
        clickImageView(imgEyeHiddenPresent, etPassPresent);
        clickImageView(imgEyeHiddenNew,etPassNew);
        clickImageView(imgEyeHiddenCf, etPassCf);
        setButton();
    }

    @SuppressLint("CutPasteId")
    private void init(){
        imgBack = (ImageView) findViewById(R.id.activity_replace_img_back);
        imgEyeHiddenPresent = (ImageView) findViewById(R.id.activity_replace_img_eye_hiden_present);
        imgEyeHiddenNew = (ImageView) findViewById(R.id.activity_replace_img_eye_hide_new);
        imgEyeHiddenCf = (ImageView) findViewById(R.id.activity_replace_img_eye_hiden_cf);

        etPassPresent = (EditText) findViewById(R.id.activity_replace_et_pass_present);
        etPassNew = (EditText) findViewById(R.id.activity_replace_et_pass_new);
        etPassCf = (EditText) findViewById(R.id.activity_replace_et_pass_cf);
        etNotify = (TextView) findViewById(R.id.activity_replace_tv_notifi);

        btnUpdate = (Button) findViewById(R.id.activity_replace_btn_update);
    }

    private void setImgBack(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReplaceActivity.this, HomeActivity.class);
                intent.putExtra("ActivityHome","FragmentSetting");
                startActivity(intent);
            }
        });
    }

    private boolean isEmpty(EditText et){
        String string = et.getText().toString();
        return (string.isEmpty());
    }

    private void showButton(){
        if(isEmpty(etPassPresent) || isEmpty(etPassNew) || isEmpty(etPassCf)){
            btnUpdate.setEnabled(false);
            Log.d("CheckPass", "Null");
            btnUpdate.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.regis_before)));
        }else{
            btnUpdate.setEnabled(true);
            Log.d("CheckPass", "NotNull");
            btnUpdate.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.replace_activity_btn)));
        }

    }

    @SuppressLint("SetTextI18n")
    private void checkPassCf(){
        if(!etPassCf.getText().toString().equals(etPassNew.getText().toString())){
            etNotify.setText("Mật khẩu nhập lại không khớp");
        }
    }

    private void setButton(){
        etPassPresent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassCf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showButton();
                checkPassCf();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void clickImageView(ImageView eyeHidden, EditText pass){
        eyeHidden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getTag() == null || (int)v.getTag() == R.mipmap.ic_launcher_eye_hidden_adaptive_fore){
                    eyeHidden.setImageResource(R.mipmap.ic_launcher_eye_adaptive_fore);
                    v.setTag(R.mipmap.ic_launcher_eye_adaptive_fore);
                    Log.d("Pass", "Pass");
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Log.d("Pass", "Pass2");

                }else{
                    eyeHidden.setImageResource(R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                    v.setTag(R.mipmap.ic_launcher_eye_hidden_adaptive_fore);
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
//                Dùng để kiểu như khi an vao mat thi no se kh con o trong edittext nua
//                neu bo di thi khi an vao mat no se chuyen ve dau edittext de nhạp, thuong neu muon thi phải bat sk cho no ve cuoi edtect
//                o day cho no ra khoi edtext luon
                pass.requestFocus();
                pass.clearFocus();
            }
        });
    }
}