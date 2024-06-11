package com.httt.test.Activity;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Adapter.TourAdapter;
import com.httt.test.Model.Tour;
import com.httt.test.R;
import com.httt.test.Repository.TourRepository;
import com.httt.test.ui.favourite.FavTourManeger;
import com.httt.test.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class AllTourActivity extends AppCompatActivity {

    private RecyclerView rcvAllTour;

    private ImageView backHome;
    private FavTourManeger favoriteTourManager = FavTourManeger.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_tour);

        rcvAllTour = findViewById(R.id.rcvAllTour);
        backHome = findViewById(R.id.imgBackHome);

        TourRepository tourRepository = new TourRepository(this);
        List<Tour> tours = new ArrayList<>();
        tours = tourRepository.initializeTours(this);

        GridLayoutManager gridVoucherManager = new GridLayoutManager(this, 2);
        rcvAllTour.setLayoutManager(gridVoucherManager);
        TourAdapter adapter = new TourAdapter(this, tours);
        rcvAllTour.setAdapter(adapter);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.navigation_home, new HomeFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    private void addFavoriteTour(Tour tour) {
        favoriteTourManager.addFavoriteTour(tour);
    }

    private void removeFavoriteTour(Tour tour) {
        favoriteTourManager.removeFavoriteTour(tour);
    }
}