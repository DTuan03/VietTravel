package com.httt.test.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Adapter.TourAdapter;
import com.httt.test.Adapter.VoucherAdapter;
import com.httt.test.Category.Category;
import com.httt.test.Category.CategoryAdapter;
import com.httt.test.Model.Tour;
import com.httt.test.Model.Voucher;
import com.httt.test.R;
import com.httt.test.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private RecyclerView rcvPopular;
    private RecyclerView rcvVoucher;
    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rcvPopular = binding.rcvPopularTour;
        categoryAdapter = new CategoryAdapter(requireContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        rcvPopular.setLayoutManager(layoutManager);

        categoryAdapter.setData(getListTourCategory());
        rcvPopular.setAdapter(categoryAdapter);

        rcvVoucher = binding.rcvVoucher;
        GridLayoutManager gridVoucherManager = new GridLayoutManager(requireContext(), 2);
        rcvVoucher.setLayoutManager(gridVoucherManager);

        VoucherAdapter voucherAdapter = new VoucherAdapter(getListVoucher());
        rcvVoucher.setAdapter(voucherAdapter);

        return root;
    }


    @NonNull
    private List<Voucher> getListVoucher() {
        List<Voucher> list = new ArrayList<>();
        list.add(new Voucher(R.drawable.logo, "Giảm giá\n10%", "Giảm 10% cho tour từ 2tr\nThời gian sử dụng: 1 ngày"));
        list.add(new Voucher(R.drawable.logo, "Giảm giá\n10%", "Giảm 10% cho tour từ 2tr\nThời gian sử dụng: 1 ngày"));
        list.add(new Voucher(R.drawable.logo, "Giảm giá\n10%", "Giảm 10% cho tour từ 2tr\nThời gian sử dụng: 1 ngày"));
        list.add(new Voucher(R.drawable.logo, "Giảm giá\n10%", "Giảm 10% cho tour từ 2tr\nThời gian sử dụng: 1 ngày"));
        list.add(new Voucher(R.drawable.logo, "Giảm giá\n10%", "Giảm 10% cho tour từ 2tr\nThời gian sử dụng: 1 ngày"));
        list.add(new Voucher(R.drawable.logo, "Giảm giá\n10%", "Giảm 10% cho tour từ 2tr\nThời gian sử dụng: 1 ngày"));
        return list;
    }

    @NonNull
    private List<Category> getListTourCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Tour> listTour = new ArrayList<>();
        listTour.add(new Tour("Da Lat", "Traveling to Da Lat", "2000", R.drawable.baseline_bookmark_border_24, R.drawable.img_dalat));
        listTour.add(new Tour("Da Lat", "Traveling to Da Lat", "2000", R.drawable.baseline_bookmark_border_24, R.drawable.img_dalat));
        listTour.add(new Tour("Da Lat", "Traveling to Da Lat", "2000", R.drawable.baseline_bookmark_border_24, R.drawable.img_dalat));
        listTour.add(new Tour("Da Lat", "Traveling to Da Lat", "2000", R.drawable.baseline_bookmark_border_24, R.drawable.img_dalat));
        listTour.add(new Tour("Da Lat", "Traveling to Da Lat", "2000", R.drawable.baseline_bookmark_border_24, R.drawable.img_dalat));

        listCategory.add(new Category("Tour 1 ngày", listTour));
        listCategory.add(new Category("Tour nhiều ngày", listTour));
        return listCategory;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

