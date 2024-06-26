package com.httt1.vietnamtravel.main.presenter;

import android.content.Context;
import android.view.MenuItem;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

//import com.httt1.vietnamtravel.History.ViewPager.View.HistoryFragment;
import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.favorite.view.FavoriteFragment;
import com.httt1.vietnamtravel.home.view.HomeFragment;
import com.httt1.vietnamtravel.setting.view.SettingFragment;

public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View view;
    private final Context context;
    public MainPresenter(MainContract.View view, Context context){
        this.view = view;
        this.context = context;
    }
    @Override
    public boolean onClickItem(MenuItem item) {
        if (item.getItemId() == R.id.navigation_home){
            Fragment fragmentHome = new HomeFragment();
            int setStatusBarColor = ContextCompat.getColor(context, R.color.fragment_home_status_bar);
            view.loadFragment(fragmentHome, setStatusBarColor);
            return true;
        }else if (item.getItemId() == R.id.navigation_favorite) {
            Fragment fragmentFavorite = new FavoriteFragment();
            int setStatusBarColor = ContextCompat.getColor(context, R.color.fragment_home_status_bar);
            view.loadFragment(fragmentFavorite, setStatusBarColor);
            return true;
        } else if (item.getItemId() == R.id.navigation_history) {
//            Fragment fragmentHistory = new HistoryFragment();
//            int setStatusBarColor = ContextCompat.getColor(context, R.color.fragment_setting_status_bar);
//            view.loadFragment(fragmentHistory, setStatusBarColor);
            return true;
        } else if (item.getItemId() == R.id.navigation_setting) {
            Fragment fragmentSetting = new SettingFragment();
            int setStatusBarColor = ContextCompat.getColor(context, R.color.fragment_setting_status_bar);
            view.loadFragment(fragmentSetting, setStatusBarColor);
            return true;
        }
        return false;
    }


}
