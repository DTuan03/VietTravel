package com.httt1.vietnamtravel.AllTours.view;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.AllTours.adapter.TourAdapter;
import com.httt1.vietnamtravel.AllTours.model.AllTourModel;
import com.httt1.vietnamtravel.AllTours.presenter.AllTourActivityContract;
import com.httt1.vietnamtravel.AllTours.presenter.AllTourPresenter;
import com.httt1.vietnamtravel.DetailTour.view.DetailTourActivity;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.databinding.ActivityAllTourBinding;
import com.httt1.vietnamtravel.favorite.model.FavoriteModel;
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class AllTourActivity extends AppCompatActivity implements AllTourActivityContract.View, TourAdapter.OnItemClickListener {

    private ActivityAllTourBinding binding;
    private RecyclerView rcvAllTour;
    private TourAdapter alltourAdapter;
    private ImageView tvbackhome;
    private int userId;
    private TextView emptySearchView;
    private EditText searchEditText;
    private List<AllTourModel> originalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllTourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); // Use 'this' for Activity context
        userId = sharedPrefsHelper.getInt("UserId"); // Default value 0 if UserId is not found

        rcvAllTour = binding.activityAlltourRcvAlltour;

        AllTourPresenter allTourPresenter = new AllTourPresenter(this);
        setAllTourAdapter(allTourPresenter, userId);

        tvbackhome = binding.activityTvBackhome;
        tvbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        emptySearchView = binding.emptySearchViewAllTour;
        searchEditText = binding.activityAlltourEtSearch;
        setupSearchFunctionality();
    }

    // Phương thức được gọi khi ImageView "Back" được nhấn
    public void onBackHomeClicked(View view) {
        onBackPressed();
    }

    // Override phương thức onBackPressed để đảm bảo quay về Fragment trước đó khi bấm nút back của thiết bị
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStack();
    }

    private void setAllTourAdapter(AllTourPresenter allTourPresenter, int userId) {
        alltourAdapter = new TourAdapter(this, userId, allTourPresenter.getAllTourRepository());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvAllTour.setLayoutManager(gridLayoutManager);
        rcvAllTour.setAdapter(alltourAdapter);

        allTourPresenter.getAllData(userId);
        alltourAdapter.setOnItemClickListener(this); // Đăng ký sự kiện item click
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

        List<AllTourModel> filteredList = new ArrayList<>();
        for (AllTourModel item : originalList) {
            if (item.getNameTour().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        alltourAdapter.setAllData(filteredList);
        alltourAdapter.notifyDataSetChanged();

        if (filteredList.isEmpty()) {
            rcvAllTour.setVisibility(View.GONE);
            emptySearchView.setVisibility(View.VISIBLE);
        } else {
            rcvAllTour.setVisibility(View.VISIBLE);
            emptySearchView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showAllData(List<AllTourModel> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                originalList = new ArrayList<>(list); // Update original list for filtering
                alltourAdapter.setAllData(list);
                alltourAdapter.notifyDataSetChanged();

                updateAllTourVisibility(list.isEmpty());
            }
        });
    }

    private void updateAllTourVisibility(boolean isEmpty) {
        if (rcvAllTour == null || emptySearchView == null) {
            return;
        }

        rcvAllTour.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
        emptySearchView.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
    }

    // Xử lý sự kiện khi người dùng nhấn vào item tour
    @Override
    public void onItemClick(int idTour, int userId) {
        Intent intent = new Intent(this, DetailTourActivity.class);
        intent.putExtra("idTour", idTour);
        intent.putExtra("idUser", userId);
        startActivity(intent);
    }
}
