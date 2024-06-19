package com.httt.viettravel.TabHistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;

import java.util.List;

public class Tab2Adapter extends RecyclerView.Adapter<Tab2Adapter.Tab2ViewHolder> {
    private List<Tour> tours;

    public Tab2Adapter(List<Tour> tours) {
        this.tours = tours;
    }

    @NonNull
    @Override
    public Tab2Adapter.Tab2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commented_tab2, parent, false);
        return new Tab2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab2Adapter.Tab2ViewHolder holder, int position) {
        Tour tour = tours.get(position);
        if (tour != null) {
//            holder.imageViewTour.setImageResource(tour.getPic());
//            holder.textViewLocation.setText(tour.getLocation());
//            holder.textViewComment.setText(tour.getComment());
//            holder.ratingBar.setRating(tour.getRating());
//            holder.textViewDate.setText(tour.getDate());
//            holder.textViewTime.setText(tour.getReviewTime());
        }

    }

    @Override
    public int getItemCount() {
        return tours.size();
    }

    public class Tab2ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewTour;
        private TextView textViewLocation, textViewComment, textViewDate, textViewTime;
        private RatingBar ratingBar;

        public Tab2ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewTour = itemView.findViewById(R.id.img);
            textViewLocation = itemView.findViewById(R.id.location);
            textViewComment = itemView.findViewById(R.id.cmt);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            textViewDate = itemView.findViewById(R.id.tvDate);
            textViewTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
