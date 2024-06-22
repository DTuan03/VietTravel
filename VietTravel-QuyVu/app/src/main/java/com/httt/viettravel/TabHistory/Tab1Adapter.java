package com.httt.viettravel.TabHistory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Image;
import com.httt.viettravel.R;
import com.httt.viettravel.Model.Tour;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.TourViewHolder> {
    private List<Tour> tourList;
    private Context context;

    public Tab1Adapter(Context context, List<Tour> tourList) {
        this.context = context;
        this.tourList = tourList;
        notifyDataSetChanged();
    }

    @Override
    public TourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        holder.bind(tour);
    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public void setTours(List<Tour> tours) {
        this.tourList = tours;
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {
        TextView nameTour;
        TextView numberDay;
        TextView totalTour;
        Button rateButton;
        private Tab1 tab1Fragment;
        private int day;
        ImageView imgTour;

        public TourViewHolder(View itemView) {
            super(itemView);
            nameTour = itemView.findViewById(R.id.NameTour);
            numberDay = itemView.findViewById(R.id.NumberDay);
            totalTour = itemView.findViewById(R.id.TotalTour);
            rateButton = itemView.findViewById(R.id.btn_rate);
            imgTour = itemView.findViewById(R.id.ImgTour); // Add ImageView
        }

        public void bind(Tour tour) {
            nameTour.setText(tour.getNameTour());
            numberDay.setText(String.valueOf(tour.getNumberDay()) +" ngày");

            totalTour.setText(String.valueOf(tour.getTotal()));

            // Load image using Picasso or any other image loading library
            Picasso.get().load(tour.getImgMainResource()).into(imgTour);

            // Lấy ngày hiện tại
            Date currentDate = new Date();

            // Kiểm tra trạng thái của Tour
            boolean isBeforeStartDate = currentDate.before(tour.getStartDay()); // Tour chưa bắt đầu
            boolean isAfterEndDate = currentDate.after(tour.getEndDay()); // Tour đã kết thúc
            boolean isDuringTour = !isBeforeStartDate && !isAfterEndDate; // Tour đang diễn ra

            if (isBeforeStartDate) { // Tour chưa bắt đầu
                rateButton.setEnabled(true);
                rateButton.setAlpha(0.5f); // Làm mờ nút
                rateButton.setText("Đánh giá");
                rateButton.setOnClickListener(v ->
                        Toast.makeText(context, "Chuyến đi này chưa bắt đầu", Toast.LENGTH_SHORT).show());
            } else if (isDuringTour) { // Tour đang diễn ra
                rateButton.setEnabled(true);
                rateButton.setAlpha(0.5f); // Làm mờ nút
                rateButton.setText("Đánh giá");
                rateButton.setOnClickListener(v ->
                        Toast.makeText(context, "Chuyến đi này đang diễn ra", Toast.LENGTH_SHORT).show());
            } else { // Tour đã kết thúc
                rateButton.setEnabled(true);
                rateButton.setAlpha(1.0f);
                rateButton.setText("Đánh giá");
                rateButton.setOnClickListener(v -> {
                    // Chuyển sang ReviewActivity
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra("idBookedTour", tour.getIdBookedTour()); // Truyền idBookedTour
                    intent.putExtra("nameTour", tour.getNameTour());
                    intent.putExtra("descriptionTour", tour.getDescriptionTour());
                    intent.putExtra("total", tour.getTotal());
                    intent.putExtra("vehicle", tour.getVehicle());
                    intent.putExtra("hotel", tour.getHotel());
                    intent.putExtra("numberDay", tour.getNumberDay());
                    context.startActivity(intent);
                });
            }
        }
    }
}










