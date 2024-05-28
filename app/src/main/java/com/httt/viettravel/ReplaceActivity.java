package com.httt.viettravel;

import android.content.Intent;
import android.os.Bundle;
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
    private ImageView imgMatAnHienTai;
    private ImageView imgMatAnMoi;
    private ImageView imgMatAnNhapLai;
    private EditText etMatKhauHienTai;
    private EditText etMatKhauMoi;
    private EditText etMatKhauNhapLai;

    private Button btnCatNhat;


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
    }

    private void init(){
        imgBack = (ImageView) findViewById(R.id.activity_replace_img_back);
        imgMatAnHienTai = (ImageView) findViewById(R.id.activity_replace_img_mat_an_hien_tai);
        imgMatAnMoi = (ImageView) findViewById(R.id.activity_replace_img_mat_an_moi);
        imgMatAnNhapLai = (ImageView) findViewById(R.id.activity_replace_img_mat_an_hien_tai);

        etMatKhauHienTai = (EditText) findViewById(R.id.activity_replace_et_mat_khau_hien_tai);
        etMatKhauMoi = (EditText) findViewById(R.id.activity_replace_et_mat_khau_moi);
        etMatKhauNhapLai = (EditText) findViewById(R.id.activity_replace_et_mat_khau_nhap_lai);

        btnCatNhat = (Button) findViewById(R.id.activity_replace_btn_cap_nhat);
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
}