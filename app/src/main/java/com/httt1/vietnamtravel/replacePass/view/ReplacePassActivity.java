package com.httt1.vietnamtravel.replacePass.view;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.replacePass.presenter.ReplaceContract;
import com.httt1.vietnamtravel.replacePass.presenter.ReplacePresenter;

public class ReplacePassActivity extends AppCompatActivity implements ReplaceContract.View {

    private EditText etPassOld, etPassNew, etPassCf;
    private ImageView imgEyeOld, imgEyeNew, imgEyeCf;
    private Button btnReplace;
    private ReplacePresenter replacePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_replace_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        int userId = sharedPrefsHelper.getInt("UserId");
        init();
        replacePresenter = new ReplacePresenter(this);
        imgEyeOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacePresenter.onEyePassClicked(imgEyeOld, etPassOld);
            }
        });
        imgEyeNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacePresenter.onEyePassClicked(imgEyeNew, etPassNew);
            }
        });
        imgEyeCf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacePresenter.onEyePassClicked(imgEyeCf, etPassCf);
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacePresenter.onClickReplace(userId);
            }
        });

    }

    private void init(){
        etPassOld = (EditText) findViewById(R.id.activity_replace_et_pass_present);
        etPassNew = (EditText) findViewById(R.id.activity_replace_et_pass_new);
        etPassCf = (EditText) findViewById(R.id.activity_replace_et_pass_cf);
        imgEyeOld = findViewById(R.id.activity_replace_img_eye_hiden_present);
        imgEyeNew = findViewById(R.id.activity_replace_img_eye_hide_new);
        imgEyeCf = findViewById(R.id.activity_replace_img_eye_hiden_cf);
        btnReplace = findViewById(R.id.activity_replace_btn_update);
    }

    @Override
    public void forcus() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                etPassOld.setText("");
                etPassOld.requestFocus();
                etPassOld.clearFocus();

                etPassNew.setText("");
                etPassNew.requestFocus();
                etPassNew.clearFocus();

                etPassCf.setText("");
                etPassCf.requestFocus();
                etPassCf.clearFocus();
                Toast.makeText(ReplacePassActivity.this, "Bạn đã đổi mật khẩu thành công.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public String getPassOld() {
        return etPassOld.getText().toString();
    }

    @Override
    public String getPassNew() {
        return etPassNew.getText().toString();
    }

    @Override
    public String getPassCf() {
        return etPassCf.getText().toString();
    }

    @Override
    public void notifi() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ReplacePassActivity.this,"Kiểm tra lai thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }
}