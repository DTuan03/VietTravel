package com.httt.viettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class AccountActivity extends AppCompatActivity {

    private TextView tvEditName, tvEditDate, tvEditPhone, tvEditEmail;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        showDialog();
        setImgBack();
    }

    private void init(){
        tvEditName = (TextView) findViewById(R.id.activity_account_tv_edit_name);
        tvEditDate = (TextView) findViewById(R.id.activity_account_tv_edit_date);
        tvEditPhone = (TextView) findViewById(R.id.activity_account_tv_edit_phone);
        tvEditEmail = (TextView) findViewById(R.id.activity_account_tv_edit_email);

        imgBack = (ImageView) findViewById(R.id.activity_account_img_back);
    }

    private void showDialog(){
        tvEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountDialogNameFragment accountNameDialogFragment = new AccountDialogNameFragment();
//                Lưu ý bên Fragment tương ứng phải sửa thành kế thừa DialogFragment (tương tự Fragment) kh thi se bao loi
                accountNameDialogFragment.show(getSupportFragmentManager(), "AccountNameDialogFragment");
            }
        });
        tvEditDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountDialogDateFragment accountDateDialogFragment = new AccountDialogDateFragment();
                accountDateDialogFragment.show(getSupportFragmentManager(), "AccountDateDialogFragment");
            }
        });

        tvEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountDialogPhoneFragment accountDialogFragment = new AccountDialogPhoneFragment();
                accountDialogFragment.show(getSupportFragmentManager(), "AccountDialogPhoneFragment");
            }
        });
        tvEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountDialogEmailFragment accountDialogEmailFragment = new AccountDialogEmailFragment();
                accountDialogEmailFragment.show(getSupportFragmentManager(), "AccountDialogEmailFragment");
            }
        });
    }
    private void setImgBack(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
                intent.putExtra("AccountActivity", "SettingFragment");
                startActivity(intent);
            }
        });
    }
}