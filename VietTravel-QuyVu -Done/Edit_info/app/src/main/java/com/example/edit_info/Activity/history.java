package com.example.edit_info.Activity;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edit_info.Adapter.TourAdapter;
import com.example.edit_info.Domain.TourItem;
import com.example.edit_info.R;

import java.util.ArrayList;
import java.util.List;


public class history extends AppCompatActivity {
    RecyclerView recyclerView;
    List<TourItem> tourItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.my_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        tourItems = new ArrayList<>();
        tourItems.add(new TourItem(R.drawable.halong, "Location 1"));
        tourItems.add(new TourItem(R.drawable.sapa, "Location 2"));
        tourItems.add(new TourItem(R.drawable.doramon, "Location 3"));
//

        TourAdapter adapter = new TourAdapter(tourItems);
        recyclerView.setAdapter(adapter);

//

    }
}