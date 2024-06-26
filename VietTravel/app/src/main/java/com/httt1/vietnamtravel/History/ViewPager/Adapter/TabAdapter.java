package com.httt1.vietnamtravel.History.ViewPager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.httt1.vietnamtravel.History.Rated.View.RatedFragment;
import com.httt1.vietnamtravel.History.Unrated.View.UnratedFragment;

public class TabAdapter extends FragmentStateAdapter {
    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new UnratedFragment();
            case 1:
                return new RatedFragment();
            default:
                return new UnratedFragment();

        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
