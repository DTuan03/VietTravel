package com.httt.viettravel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Adapter.CategoryAdapter;
import com.httt.viettravel.Model.Category;
import com.httt.viettravel.Adapter.CategoryAdapter;
import com.httt.viettravel.Adapter.TourAdapter;
import com.httt.viettravel.Model.Tour;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    private RecyclerView rcv_category;
    private CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        rcv_category=findViewById(R.id.rcv_category);

        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_category.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcv_category.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory() {
        List<Category> list = new ArrayList<>();
        List<Tour> listTour = new ArrayList<>();


        listTour.add(new Tour(R.drawable.halong,"3N2D", "Quảng Ninh","1 triệu"));
        listTour.add(new Tour(R.drawable.halong,"3N2D", "Quảng Ninh","1 triệu"));
        listTour.add(new Tour(R.drawable.sapa,"3N2D", "Quảng Ninh","1 triệu"));
        listTour.add(new Tour(R.drawable.halong,"3N2D", "Quảng Ninh","1 triệu"));
        listTour.add(new Tour(R.drawable.sapa,"3N2D", "Quảng Ninh","1 triệu"));
        listTour.add(new Tour(R.drawable.halong,"3N2D", "Quảng Ninh","1 triệu"));
        list.add(new Category("Tour một ngày",listTour));
        list.add(new Category("Tour nhiều ngày",listTour));

        return list;
    }


}


//    RecyclerView recyclerView;
//    List<Tour> tours;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_history);
//
//        recyclerView = findViewById(R.id.rcv_category);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        tours = new ArrayList<>();
//        tours.add(new Tour(R.drawable.halong, "2N1Đ", "Hà Nội - Phú Quốc", "VND2.000.000"));
//        tours.add(new Tour(R.drawable.sapa, "4N1Đ", "Hà Nội - SaPa", "VND4.000.000"));
//        tours.add(new Tour(R.drawable.halong, "2N1Đ", "Hà Nội - Phú Quốc", "VND2.000.000"));
//        tours.add(new Tour(R.drawable.sapa, "4N1Đ", "Hà Nội - SaPa", "VND4.000.000"));
//        tours.add(new Tour(R.drawable.halong, "2N1Đ", "Hà Nội - Phú Quốc", "VND2.000.000"));
//        TourAdapter adapter = new TourAdapter();
//        recyclerView.setAdapter(adapter);
//
//    }
//}
