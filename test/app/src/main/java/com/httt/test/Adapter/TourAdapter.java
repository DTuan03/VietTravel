package com.httt.test.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Model.FavTour;
import com.httt.test.Model.Tour;
import com.httt.test.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private Boolean isFav = false;
    public List<Tour> tourList;
    private Context context;
    public FavTour favouriteTour = new FavTour();
    public TourAdapter(Context context, List<Tour> tourList) {
        this.context = context;
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
        public TextView tvRating;
        public TextView tvPrice;
        public ImageView tvFav;
        public ImageView imgTour;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameTour = itemView.findViewById(R.id.tv_title);
            tvRating = itemView.findViewById(R.id.tv_rating);
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
            holder.tvRating.setText(String.format("%.2f", tour.getTv_rating()));
            holder.tvPrice.setText(String.format("%.2f", tour.getPrice()));
            holder.imgTour.setImageURI(Uri.parse(tour.getImg_tour()));
            holder.tvFav.setOnClickListener(v -> {
                if (!isFav) {
                    holder.tvFav.setImageResource(R.drawable.baseline_bookmark_24);
                    isFav = true;
                    favouriteTour.addFavTour(tour);
                } else {
                    holder.tvFav.setImageResource(R.drawable.baseline_bookmark_unfav);
                    isFav = false;
                    favouriteTour.removeFavTour(tour);
                    favouriteTour.getFavTours().remove(tour);
                    notifyDataSetChanged();
                }
                Toast.makeText(context,"Add favorite tour: "+ tour.getTv_name_tour(), Toast.LENGTH_LONG).show();
            });
        }
    }
}