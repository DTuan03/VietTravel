package com.httt.viettravel;

import android.annotation.SuppressLint;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

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

    public boolean handleNavigationItemSelected(MenuItem item) {
        ColorStateList iconTintList = getColorStateList(R.color.regis_after);
        Log.d("HomeActivity", "Item selected: " + item.getTitle());
        if (item.getItemId() == R.id.navigation_home) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                item.setIconTintList(iconTintList);
                Log.d("a","d");
                Log.d("HomeActivity", "TintList selected: " + item.getIconTintList());
            }
            return true;
        } else if (item.getItemId() == R.id.navigation_favorite) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Log.d("HomeActivity", "TintList selected: " + item.getIconTintList());

            }
            return true;
        } else if (item.getItemId() == R.id.navigation_history) {
            return true;
        } else if (item.getItemId() == R.id.navigation_setting) {
            return true;
        }
        return false;
    }
}