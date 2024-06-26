package com.httt1.vietnamtravel.DetailTour.view;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.httt1.vietnamtravel.bookTour.view.BookTourActivity;
import com.httt1.vietnamtravel.DetailTour.adapter.ImagePagerAdapter;
import com.httt1.vietnamtravel.DetailTour.model.DetailModel;
import com.httt1.vietnamtravel.DetailTour.model.DetailRepository;
import com.httt1.vietnamtravel.DetailTour.presenter.DetailTourActivityContract;
import com.httt1.vietnamtravel.DetailTour.presenter.DetailTourPresenter;
import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

public class DetailTourActivity extends AppCompatActivity implements DetailTourActivityContract.View {
    private int idTour;
    private int idUser;
    private TextView tvTitle, tvRating, tvDescription, tvTime, tvPrice, tvVehicle, tvHotel;
    private DetailTourPresenter presenter;
    private ImageView ivBack;
    private RecyclerView recyclerView;
//    private ReviewAdapter reviewAdapter;
//    private List<ReviewModel> reviewList;
    private ViewPager2 viewPager;
    private ImagePagerAdapter imagePagerAdapter;
    private List<String> imageUrls;
    private Button btnBookTour;
    private ImageView imgFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tour);
        // Retrieve userId from SharedPreferences
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); // Use 'this' for Activity context
        idUser = sharedPrefsHelper.getInt("UserId"); // Default value 0 if UserId is not found

        // Retrieve data from intent
        Intent intent = getIntent();
        idTour = intent.getIntExtra("idTour",0); // Default value 0 if idTour is not passed

        // Initialize views
        tvTitle = findViewById(R.id.activity_tv_title_detail_tour);
        tvRating = findViewById(R.id.activity_tv_rating_detail_tour);
        tvDescription = findViewById(R.id.activity_tv_description_detail_tour);
        tvTime = findViewById(R.id.activity_tv_time_detail_tour);
        tvPrice = findViewById(R.id.activity_tv_price_detail_tour);
        tvVehicle = findViewById(R.id.activity_tv_vehicle_detail_tour);
        tvHotel = findViewById(R.id.activity_tv_hotel_detail_tour);
        imgFav = findViewById(R.id.activity_img_favourite_detail_tour);

        ivBack = findViewById(R.id.activity_img_back_detail_tour);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Initialize presenter and repository
        DetailRepository detailRepository = new DetailRepository();
        presenter = new DetailTourPresenter(this, detailRepository);

//        // Setup RecyclerView for reviews
//        recyclerView = findViewById(R.id.recycler_view_reviews);
//        reviewList = new ArrayList<>();
//        reviewAdapter = new ReviewAdapter(this, reviewList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(reviewAdapter);

        // Setup ViewPager2 and TabLayout for images
        viewPager = findViewById(R.id.viewpager_image_detail_tour);
        imageUrls = new ArrayList<>();
        imagePagerAdapter = new ImagePagerAdapter(this, imageUrls);
        viewPager.setAdapter(imagePagerAdapter);

        // Load tour details and images
        presenter.getDetailData(idUser, idTour);
//        presenter.getReviews(idTour);

        // Setup onClickListener for favorite icon
        imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgFav.getTag() != null && imgFav.getTag().equals("fav")) {
                    // Xóa yêu thích
                    detailRepository.removeFavorite(idUser, idTour);
                    imgFav.setImageResource(R.drawable.baseline_favorite_border_24);
                } else {
                    // Thêm yêu thích
                    detailRepository.addFavorite(idUser, idTour);
                    imgFav.setImageResource(R.drawable.baseline_favorite_24);
                }
            }
        });

        btnBookTour = findViewById(R.id.activity_btn_booking_detail_tour);
        btnBookTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailTourActivity.this, BookTourActivity.class);
                intent.putExtra("idTour", idTour);
                intent.putExtra("idUser", idUser);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Remove this line to avoid error
        // getSupportFragmentManager().popBackStack();
    }

    @Override
    public void showDetailData(DetailModel detailTour) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(detailTour.getNameTour());
                tvRating.setText(String.valueOf(detailTour.isFavorite()));
                tvDescription.setText(detailTour.getDescription());
                tvTime.setText(String.valueOf(detailTour.getNumberDay()));
                tvPrice.setText(String.valueOf(detailTour.getPrice()));
                tvVehicle.setText(detailTour.getVehicle());
                tvHotel.setText(detailTour.getHotel());

                // Set favorite icon based on tour's favorite status
                if (detailTour.isFavorite()) {
                    imgFav.setImageResource(R.drawable.baseline_favorite_24);
                    imgFav.setTag("fav");
                } else {
                    imgFav.setImageResource(R.drawable.baseline_favorite_border_24);
                    imgFav.setTag(null);
                }

                imageUrls.clear();
                imageUrls.addAll(detailTour.getImageUrls());
                imagePagerAdapter.notifyDataSetChanged();
            }
        });
    }

//    @Override
//    public void showReviews(List<ReviewModel> reviews) {
//        runOnUiThread(() -> {
//            reviewList.clear();
//            reviewList.addAll(reviews);
//            reviewAdapter.notifyDataSetChanged();
//        });
//    }
}
