package com.httt1.vietnamtravel.AllTours.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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
import com.httt1.vietnamtravel.home.model.HomeModel;

import java.util.List;

public class AllTourActivity extends AppCompatActivity implements AllTourActivityContract.View, TourAdapter.OnItemClickListener {

    private ActivityAllTourBinding binding;
    private RecyclerView rcvAllTour;
    private TourAdapter alltourAdapter;
    private ImageView tvbackhome;
    private int userId;

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

    @Override
    public void showAllData(List<AllTourModel> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alltourAdapter.setAllData(list);
                alltourAdapter.notifyDataSetChanged();
            }
        });
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
