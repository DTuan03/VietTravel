package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return handleNavigationItemSelected(menuItem);
            }
        });
    }

    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null && "FragmentSetting".equals(intent.getStringExtra("ActivityHome"))) {
            loadFragment(fragmentSetting);
        }

    }

    public boolean handleNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.navigation_home) {
            loadFragment(fragmentHome);
            return true;
        } else if (item.getItemId() == R.id.navigation_favorite) {
            return true;
        } else if (item.getItemId() == R.id.navigation_history) {

            return true;
        } else if (item.getItemId() == R.id.navigation_setting) {
            loadFragment(fragmentSetting);
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