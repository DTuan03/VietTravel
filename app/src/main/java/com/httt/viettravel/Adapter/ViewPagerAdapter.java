package com.httt.viettravel.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.httt.viettravel.FavoriteFragment;
import com.httt.viettravel.ProposeFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    //ham tra ve fragment
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ProposeFragment();
            case 1:
                return new FavoriteFragment();
            case 2:
                return new ProposeFragment();
            default:
                return new ProposeFragment();
        }
    }

    //tra ve so luong TAB co
    @Override
    public int getItemCount() {
        return 3;
    }

    //set tieu de cho tablelayout
    @Override
    public int getItemViewType(int position) {
        String title = "";

        switch (position){
            case 0:
                title = "Đề xuất";
                break;
            case 1:
                title = "Không thể bỏ lỡ";
                break;
            case 2:
                title = "Cẩm nang du lịch";
                break;
        }
        return super.getItemViewType(position);
    }


}
