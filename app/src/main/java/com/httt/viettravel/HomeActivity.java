package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.httt.viettravel.HomeFragment;
import com.httt.viettravel.R;
import com.httt.viettravel.SettingFragment;

public class HomeActivity extends AppCompatActivity {
    Fragment fragmentHome = new HomeFragment();
    Fragment fragmentSetting = new SettingFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return handleNavigationItemSelected(menuItem);
            }
        });
    }
    public void onResume() {
        super.onResume();
        Log.d("JDHSIUDEFHSDEI8u7Fh", "YGDEF7Y8UsGHFI8U7eWHDFO9I");
        init();
        Intent intent = getIntent();
        if (intent != null && "SettingFragment".equals(intent.getStringExtra("ReplaceActivity"))) {
            loadFragment(fragmentSetting);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.fragment_setting_status_bar));
            bottomNavigationView.setSelectedItemId(R.id.navigation_setting); // Đặt mục đã chọn của BottomNavigationView về Setting
        }else{
            if (intent != null && "SettingFragment".equals(intent.getStringExtra("AccountActivity"))) {
                loadFragment(fragmentSetting);
                getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.fragment_setting_status_bar));
                bottomNavigationView.setSelectedItemId(R.id.navigation_setting); // Đặt mục đã chọn của BottomNavigationView về Setting
            }
        }

    }

    private void init(){
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    }

    public boolean handleNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.navigation_home) {
            loadFragment(fragmentHome);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.fragment_home_status_bar));
            return true;
        } else if (item.getItemId() == R.id.navigation_favorite) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
            return true;
        } else if (item.getItemId() == R.id.navigation_history) {

            return true;
        } else if (item.getItemId() == R.id.navigation_setting) {
            loadFragment(fragmentSetting);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.fragment_setting_status_bar));
            return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void removeFragment(Fragment fragment){
        // Bắt đầu giao dịch FragmentTransaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Xóa Fragment được chỉ định
        transaction.remove(fragment);

        // Thêm giao dịch vào back stack
        transaction.addToBackStack(null);

        // Hoàn thành và xác nhận giao dịch
        transaction.commit();
    }
}