package com.httt1.vietnamtravel.ui.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.databinding.ActivityAllTourBinding;
import com.httt1.vietnamtravel.ui.adapter.TourAdapter;
import com.httt1.vietnamtravel.ui.model.TourModel;
import com.httt1.vietnamtravel.ui.presenter.AllTourActivityContract;
import com.httt1.vietnamtravel.ui.presenter.AllTourPresenter;

import java.util.List;

public class AllTourActivity extends AppCompatActivity implements AllTourActivityContract.View {

    private ActivityAllTourBinding binding;
    private RecyclerView rcvAllTour;
    private TourAdapter alltourAdapter;
    private ImageView tvbackhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllTourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        int userId = 1;
        Log.d("Thong tin UserId 18:03", "Thong tin: " + userId);
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
        GridLayoutManager gridVoucherManager = new GridLayoutManager(this, 2);
        rcvAllTour.setLayoutManager(gridVoucherManager);
        rcvAllTour.setAdapter(alltourAdapter);

        allTourPresenter.getAllData(userId);
    }

    public void showAllData(List<TourModel> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Cập nhật dữ liệu vào adapter và RecyclerView
                alltourAdapter.setDataCombo(AllTourActivity.this, list);
                alltourAdapter.notifyDataSetChanged();
            }
        });
    }
}