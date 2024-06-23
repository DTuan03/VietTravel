package com.httt1.vietnamtravel.ui.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.databinding.ActivityAllTourBinding;
import com.httt1.vietnamtravel.ui.adapter.TourAdapter;
import com.httt1.vietnamtravel.ui.model.AllTourRepository;
import com.httt1.vietnamtravel.ui.model.TourModel;
import com.httt1.vietnamtravel.ui.presenter.AllTourActivityContract;
import com.httt1.vietnamtravel.ui.presenter.AllTourPresenter;

import java.util.List;

public class AllTourActivity extends AppCompatActivity implements AllTourActivityContract.View {

    private ActivityAllTourBinding binding;
    private RecyclerView rcvAllTour;
    private TourAdapter alltourAdapter;
    private AllTourRepository allTourRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tour);

        binding = ActivityAllTourBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rcvAllTour = binding.activityAlltourRcvAlltour;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcvAllTour.setLayoutManager(layoutManager);

        // Khởi tạo adapter
        alltourAdapter = new TourAdapter(this, userId, allTourRepository); // Điền tham số phù hợp
        rcvAllTour.setAdapter(alltourAdapter);

        // Gọi phương thức để lấy dữ liệu
        AllTourPresenter allTourPresenter = new AllTourPresenter(this);
        allTourPresenter.getAllData(userId);
    }

    @Override
    public void showAllData(List<TourModel> list) {
        // Cập nhật dữ liệu vào adapter và thông báo thay đổi
        if (alltourAdapter != null) {
            alltourAdapter.setDataCombo(this, list);
            alltourAdapter.notifyDataSetChanged();
        }
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

}