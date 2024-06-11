package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReplaceActivity extends AppCompatActivity {

    private ImageView imgBack;
    private ImageView imgEyeHidenPresent;
    private ImageView imgEyeHidenNew;
    private ImageView imgEyeHidenCf;
    private EditText etPassPresent;
    private EditText etPassNew;
    private EditText etPassCf;

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
        setButton();
    }

    @SuppressLint("CutPasteId")
    private void init(){
        imgBack = (ImageView) findViewById(R.id.activity_replace_img_back);
        imgEyeHidenPresent = (ImageView) findViewById(R.id.activity_replace_img_eye_hiden_present);
        imgEyeHidenNew = (ImageView) findViewById(R.id.activity_replace_img_eye_hide_new);
        imgEyeHidenCf = (ImageView) findViewById(R.id.activity_replace_img_eye_hiden_present);

        etPassPresent = (EditText) findViewById(R.id.activity_replace_et_pass_present);
        etPassNew = (EditText) findViewById(R.id.activity_replace_et_pass_new);
        etPassCf = (EditText) findViewById(R.id.activity_replace_et_pass_cf);

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
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}