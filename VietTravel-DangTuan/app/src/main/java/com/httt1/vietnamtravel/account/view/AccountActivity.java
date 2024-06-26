package com.httt1.vietnamtravel.account.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.account.presenter.AccountContract;
import com.httt1.vietnamtravel.account.presenter.AccountPresenter;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;

public class AccountActivity extends AppCompatActivity implements AccountContract.View, AccountContract.OnDataChangedListener {
    private TextView tvName, tvDate, tvPhone, tvEmail, tvAddress;
    private TextView tvSetName, tvSetDate, tvSetPhone, tvSetEmail, tvSetAddress;
    private AccountPresenter accountPresenter;
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
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this);
        int userId = sharedPrefsHelper.getInt("UserId");
        init();

        accountPresenter = new AccountPresenter(this);
        accountPresenter.getInfo(userId);

        showDialog();
    }

    private void init(){
        tvName = findViewById(R.id.activity_account_tv_show_name);
        tvDate = findViewById(R.id.activity_account_tv_show_date);
        tvPhone = findViewById(R.id.activity_account_tv_show_phone);
        tvEmail = findViewById(R.id.activity_account_tv_show_email);
        tvAddress = findViewById(R.id.activity_account_tv_show_country);
        tvSetName = findViewById(R.id.activity_account_tv_edit_name);
        tvSetDate = findViewById(R.id.activity_account_tv_edit_date);
        tvSetPhone = findViewById(R.id.activity_account_tv_edit_phone);
        tvSetEmail = findViewById(R.id.activity_account_tv_edit_email);
        tvSetAddress = findViewById(R.id.activity_account_tv_edit_country);
    }

    @Override
    public void setUserName(String userName) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvName.setText(userName);
            }
        });
    }

    @Override
    public void setDate(String userDate) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvDate.setText(userDate);
            }
        });
    }

    @Override
    public void setPhone(String userPhone) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvPhone.setText(userPhone);
            }
        });
    }

    @Override
    public void setEmail(String userEmail) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvEmail.setText(userEmail);
            }
        });
    }

    @Override
    public void setAddress(String userAddress) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvAddress.setText(userAddress);
            }
        });
    }

    private void showDialog(){
        tvSetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragmentDiaLogName accountFragmentDiaLogName = new AccountFragmentDiaLogName();
//                Lưu ý bên Fragment tương ứng phải sửa thành kế thừa DialogFragment (tương tự Fragment) kh thi se bao loi
                accountFragmentDiaLogName.show(getSupportFragmentManager(), "AccountNameDialogFragment");
            }
        });
        tvSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragmentDiaLogDate accountFragmentDiaLogDate = new AccountFragmentDiaLogDate();
                accountFragmentDiaLogDate.show(getSupportFragmentManager(), "AccountDateDialogFragment");
            }
        });

        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragmentDiaLogPhone accountDialogPhoneFragment = new AccountFragmentDiaLogPhone();
                accountDialogPhoneFragment.show(getSupportFragmentManager(), "AccountDialogPhoneFragment");
            }
        });
        tvSetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragmentDiaLogEmail accountFragmentDiaLogEmail = new AccountFragmentDiaLogEmail();
                accountFragmentDiaLogEmail.show(getSupportFragmentManager(), "AccountDialogEmailFragment");
            }
        });

        tvSetAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragmentDiaLogAddress accountFragmentDiaLogAddress = new AccountFragmentDiaLogAddress();
                accountFragmentDiaLogAddress.show(getSupportFragmentManager(), "AccountDialogEmailFragment");
            }
        });
    }

    @Override
    public void onDataChanged() {
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this);
        int userId = sharedPrefsHelper.getInt("UserId");
        accountPresenter.getInfo(userId);
        Log.d("sshshs", "jusdfvfdvmnfdijuvnfrdiuvnui8fgvxhushsecxsc");
    }
}