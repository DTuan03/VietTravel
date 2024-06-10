package com.httt.test.ui.favourite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Adapter.FavTourAdapter;
import com.httt.test.Model.FavTour;
import com.httt.test.databinding.FragmentFavouriteBinding;

public class FavouriteFragment extends Fragment {

    private FavTour favTour;
    private RecyclerView rcvFavTour;
    private FragmentFavouriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFavouriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        favTour = new FavTour();

        rcvFavTour = binding.rcvFavTour;
        rcvFavTour.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        FavTourAdapter adapter = new FavTourAdapter(favTour, requireContext());
        rcvFavTour.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}