package com.httt.viettravel.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.httt.viettravel.GuideFragment;
import com.httt.viettravel.ProposeFragment;
import com.httt.viettravel.RecommendFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ProposeFragment();
            case 1:
                return new RecommendFragment();
            case 2:
                return new GuideFragment();
            default:
                return new ProposeFragment();
        }
    }

    //tra ve so luong TAB co
    @Override
    public int getItemCount() {
        return 3;
    }
}
