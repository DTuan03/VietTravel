package com.httt1.vietnamtravel.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder> {

    private List<HomeModel> listDiscover;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private int userId;
    private HomeRepository homeRepository;

    public interface OnItemClickListener {
        void onItemClick(int idTour, int idUser);
    }

    public DiscoverAdapter(Context context, int userId, HomeRepository homeRepository) {
        this.context = context;
        this.listDiscover = new ArrayList<>();
        this.userId = userId;
        this.homeRepository = homeRepository;
    }

    public void setDataDiscover(List<HomeModel> listDiscover) {
        this.listDiscover = listDiscover;
        notifyDataSetChanged(); // Notify adapter about data change
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public DiscoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover, parent, false);
        return new DiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverViewHolder holder, int position) {
        HomeModel discover = listDiscover.get(position);
        int tourId = discover.getTourId();
        String uriImgDiscover = discover.getUrlImg();
        String tvNameTour = discover.getNameTour();
        int tvPriceTour = discover.getPrice();

        Picasso.get().load(uriImgDiscover).error(R.drawable.img_0).into(holder.image);
        holder.tvNameTour.setText(tvNameTour);
        holder.tvPriceTour.setText(String.valueOf(tvPriceTour));

        // Check and update favorite icon
        if (discover.isFavorite()) {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Icon already favorite
        } else {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Icon not favorite
        }

        // Handle click event for favorite icon
        holder.imgFav.setOnClickListener(v -> {
            if (discover.isFavorite()) {
                // Remove from favorites
                // homeRepository.removeFavorite(userId, discover.getTourId());
                // discover.setIsFavorite(false); // Update tour favorite status
                holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Update icon
            } else {
                // Add to favorites
                // homeRepository.addFavorite(userId, discover);
                // discover.setIsFavorite(true); // Update tour favorite status
                holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Update icon
            }
        });

        // Add click event to item
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(tourId, userId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDiscover.size();
    }

    public class DiscoverViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView tvNameTour;
        private TextView tvPriceTour;
        private ImageView imgFav;

        public DiscoverViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_img_tour);
            tvNameTour = itemView.findViewById(R.id.item_tv_name_tour);
            tvPriceTour = itemView.findViewById(R.id.item_price_tour);
            imgFav = itemView.findViewById(R.id.item_img_favorite);
        }
    }
}
