package com.httt.test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Model.Tour;
import com.httt.test.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private List<Tour> tourList;

    public void setData(List<Tour> tourList) {
        this.tourList = tourList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return tourList != null ? tourList.size() : 0;
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameTour;
        public TextView tvDescription;
        public TextView tvPrice;
        public ImageView tvFav;
        public ImageView imgTour;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameTour = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPrice = itemView.findViewById(R.id.price);
            tvFav = itemView.findViewById(R.id.tv_fav);
            imgTour = itemView.findViewById(R.id.img_tour);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        if (tour != null) {
            holder.tvNameTour.setText(tour.getTv_name_tour());
            holder.tvDescription.setText(tour.getTv_description());
            holder.tvPrice.setText(tour.getPrice());
            holder.tvFav.setImageResource(tour.getTv_fav());
            holder.imgTour.setImageResource(tour.getImg_tour());
        }
    }
}