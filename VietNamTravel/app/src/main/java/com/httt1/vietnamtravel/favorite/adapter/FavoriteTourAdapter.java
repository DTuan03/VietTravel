package com.httt1.vietnamtravel.favorite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.favorite.model.FavoriteModel;
import com.httt1.vietnamtravel.favorite.model.FavoriteTourRepository;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteTourAdapter extends RecyclerView.Adapter<FavoriteTourAdapter.FavoriteTourViewHolder> {

    private List<FavoriteModel> listFavoriteTour;
    private final Context context;
    private final int userId;
    private final FavoriteTourRepository favoriteTourRepository;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int idTour, int userId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public FavoriteTourAdapter(Context context, int userId, FavoriteTourRepository favoriteTourRepository) {
        this.context = context;
        this.userId = userId;
        this.favoriteTourRepository = favoriteTourRepository;
    }

    public void setFavoriteTourData(List<FavoriteModel> listFavoriteTour) {
        this.listFavoriteTour = listFavoriteTour;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoriteTourAdapter.FavoriteTourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover, parent, false);
        return new FavoriteTourAdapter.FavoriteTourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTourAdapter.FavoriteTourViewHolder holder, int position) {
        FavoriteModel favtour = listFavoriteTour.get(position);
        int tourId = favtour.getTourId();
        Picasso.get().load(favtour.getUrlImg()).error(R.drawable.img_0).into(holder.image);
        holder.tvNameTour.setText(favtour.getNameTour());
        holder.tvPriceTour.setText(String.valueOf(favtour.getPrice()));
        holder.avgStar.setText(String.valueOf(favtour.getAvgrStar()));

        // Xử lý sự kiện khi người dùng ấn vào nút yêu thích
        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favtour.isFavorite()) {
                    // Xóa yêu thích
                    favoriteTourRepository.removeFavorite(userId, tourId); // Xóa khỏi cơ sở dữ liệu
                    favtour.setFavorite(false); // Cập nhật trạng thái yêu thích của tour trong danh sách hiện tại
                    holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Cập nhật icon
                } else {
                    // Thêm yêu thích
                    favoriteTourRepository.addFavorite(userId, tourId); // Thêm vào cơ sở dữ liệu
                    favtour.setFavorite(true); // Cập nhật trạng thái yêu thích của tour trong danh sách hiện tại
                    holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Cập nhật icon
                }
            }
        });

        // Kiểm tra và cập nhật icon yêu thích
        if (favtour.isFavorite()) {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Icon đã favorite
        } else {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Icon chưa favorite
        }

        // Xử lý sự kiện khi người dùng nhấn vào item tour
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(favtour.getTourId(), userId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFavoriteTour != null ? listFavoriteTour.size() : 0;
    }

    public static class FavoriteTourViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView tvNameTour;
        private TextView tvPriceTour;
        private ImageView imgFav;
        private TextView avgStar;

        public FavoriteTourViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_img_discover_tour);
            tvNameTour = itemView.findViewById(R.id.item_tv_name_discover_tour);
            tvPriceTour = itemView.findViewById(R.id.item_price_discover_tour);
            imgFav = itemView.findViewById(R.id.item_img_discover_favorite);
            avgStar = itemView.findViewById(R.id.item_discover_tv_avg_star);
        }
    }
}
