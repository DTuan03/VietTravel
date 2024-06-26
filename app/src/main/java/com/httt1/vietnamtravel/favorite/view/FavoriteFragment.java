package com.httt1.vietnamtravel.favorite.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.DetailTour.view.DetailTourActivity;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.databinding.FragmentFavoriteBinding;
import com.httt1.vietnamtravel.favorite.adapter.FavoriteTourAdapter;
import com.httt1.vietnamtravel.favorite.model.FavoriteModel;
import com.httt1.vietnamtravel.favorite.presenter.FavoriteContract;
import com.httt1.vietnamtravel.favorite.presenter.FavoritePresenter;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment implements FavoriteContract.View {

    private FragmentFavoriteBinding binding;
    private RecyclerView rcvFavTour;
    private FavoritePresenter favoritePresenter;
    private FavoriteTourAdapter favoriteTourAdapter;
    private TextView emptyView;
    private TextView emptySearchView;
    private EditText searchEditText;
    private List<FavoriteModel> originalList;
    private int userId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(requireContext()); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        userId = sharedPrefsHelper.getInt("UserId");

        rcvFavTour = binding.fragmentFavoriteRcvFavtour;
        emptyView = binding.emptyViewFavTour;
        emptySearchView = binding.emptySearchViewFavTour;
        favoritePresenter = new FavoritePresenter(this, requireContext());
        setFavTourAdapter(favoritePresenter, userId);

        searchEditText = binding.fragmentFavoriteEtSearch;
        setupSearchFunctionality();

        return root;
    }

    private void setupSearchFunctionality() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        if (originalList == null) {
            return;
        }

        List<FavoriteModel> filteredList = new ArrayList<>();
        for (FavoriteModel item : originalList) {
            if (item.getNameTour().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        favoriteTourAdapter.setFavoriteTourData(filteredList);
        favoriteTourAdapter.notifyDataSetChanged();

        if (filteredList.isEmpty()) {
            rcvFavTour.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
            emptySearchView.setVisibility(View.VISIBLE);
        } else {
            rcvFavTour.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
            emptySearchView.setVisibility(View.GONE);
        }
    }

    private void setFavTourAdapter(FavoritePresenter favoritePresenter, int userId) {
        favoriteTourAdapter = new FavoriteTourAdapter(requireContext(), userId, favoritePresenter.getFavoriteTourRepository());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        rcvFavTour.setLayoutManager(gridLayoutManager);
        rcvFavTour.setAdapter(favoriteTourAdapter);

        favoriteTourAdapter.setOnItemClickListener((idTour, idUser) -> {
            Intent intent = new Intent(getActivity(), DetailTourActivity.class);
            intent.putExtra("idTour", idTour);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });

        favoritePresenter.getDataFavoriteTour(userId);
    }

    @Override
    public void showDataFavoriteTour(List<FavoriteModel> list) {
        // Check if the fragment is still attached to the activity
        if (isAdded()) {
            requireActivity().runOnUiThread(() -> {
                originalList = new ArrayList<>(list); // Save original list for search filtering
                favoriteTourAdapter.setFavoriteTourData(list);
                favoriteTourAdapter.notifyDataSetChanged();

                if (rcvFavTour != null && emptyView != null) {
                    if (list.isEmpty()) {
                        rcvFavTour.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                        emptySearchView.setVisibility(View.VISIBLE);
                    } else {
                        rcvFavTour.setVisibility(View.VISIBLE);
                        emptyView.setVisibility(View.GONE);
                        emptySearchView.setVisibility(View.GONE);
                    }
                } else {
                    // Log an error message or handle the null case appropriately
                    Log.e("FavoriteFragment", "RecyclerView or EmptyView is null");
                }
            });
        } else {
            Log.e("FavoriteFragment", "Fragment is not attached to the activity");
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
