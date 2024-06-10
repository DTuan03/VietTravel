package com.httt.test.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Adapter.FavTourAdapter;
import com.httt.test.Adapter.TourAdapter;
//import com.httt.test.Adapter.VoucherAdapter;
import com.httt.test.Adapter.VoucherAdapter;
import com.httt.test.Category.Category;
import com.httt.test.Category.CategoryAdapter;
import com.httt.test.Model.Tour;
import com.httt.test.Model.Voucher;
import com.httt.test.R;
import com.httt.test.Repository.TourRepository;
import com.httt.test.Repository.VoucherRepository;
import com.httt.test.databinding.FragmentFavouriteBinding;
import com.httt.test.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private RecyclerView rcvPopular;
    private RecyclerView rcvVoucher;
    private CategoryAdapter categoryAdapter;

    private VoucherAdapter voucherAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rcvPopular = binding.rcvPopularTour;
        categoryAdapter = new CategoryAdapter(requireContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        rcvPopular.setLayoutManager(layoutManager);

        categoryAdapter.setData(getListTourCategory());
        rcvPopular.setAdapter(categoryAdapter);


        rcvVoucher = binding.rcvVoucher;
        VoucherRepository voucherRepository = new VoucherRepository(getContext());
        List<Voucher> vouchers = new ArrayList<>();
        vouchers = voucherRepository.initializeVouchers(getContext());

        GridLayoutManager gridVoucherManager = new GridLayoutManager(requireContext(), 2);
        rcvVoucher.setLayoutManager(gridVoucherManager);
        VoucherAdapter voucherAdapter = new VoucherAdapter(getContext(), vouchers);
        rcvVoucher.setAdapter(voucherAdapter);

        return root;
    }

    @NonNull
    private List<Category> getListTourCategory() {
        List<Category> listCategory = new ArrayList<>();

        TourRepository tourRepository = new TourRepository(getContext());
        List<Tour> tours = new ArrayList<>();
        tours = tourRepository.initializeTours(getContext());

        listCategory.add(new Category("Tour 1 ngày", tours));
//        listCategory.add(new Category("Tour nhiều ngày", tours));

        return listCategory;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

