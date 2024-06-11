package com.httt.test.Adapter;

import static com.httt.test.Model.FavTour.tourMap;

import android.annotation.SuppressLint;
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

public class FavTourAdapter extends RecyclerView.Adapter<FavTourAdapter.FavTourViewHolder> {

    private FavTour favTour;
    private Context context;
    private List<FavTour> favTourList;

    public FavTourAdapter(FavTour favTour, Context context) {
        this.favTour = favTour;
        this.context = context;
    }

    @NonNull
    @Override
    public FavTourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fav_tour, parent, false);
        return new FavTourAdapter.FavTourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavTourViewHolder holder, int position) {
        Tour tour = favTour.getFavTours().get(position);
        holder.tvNameTour.setText(tour.getTv_name_tour());
        holder.tvDescription.setText(tour.getTv_description());
        holder.tvPrice.setText(String.format("%.2f", tour.getPrice()));
        holder.imgTour.setImageURI(Uri.parse(tour.getImg_tour()));
        holder.tvFav.setOnClickListener(v -> {
            favTour.removeFavTour(tour);
            favTour.getFavTours().remove(tour);
            notifyDataSetChanged(); // Cập nhật lại toàn bộ view
        });
    }

    @Override
    public int getItemCount() {
        return favTour.getFavTours().size();
    }

    public static class FavTourViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameTour;
        public TextView tvDescription;
        public TextView tvPrice;
        public ImageView imgTour;
        public ImageView tvFav;

        public FavTourViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameTour = itemView.findViewById(R.id.tv_title_fav);
            tvDescription = itemView.findViewById(R.id.tv_description_fav);
            tvPrice = itemView.findViewById(R.id.tv_price_fav);
            tvFav = itemView.findViewById(R.id.tv_favTour);
            imgTour = itemView.findViewById(R.id.img_favtour);
        }
    }
}
