package com.httt1.vietnamtravel.AllTours.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.AllTours.model.AllTourModel;
import com.httt1.vietnamtravel.AllTours.model.AllTourRepository;
import com.httt1.vietnamtravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private List<AllTourModel> listAllTour;
    private Context context;
    private int userId;
    private AllTourRepository allTourRepository;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int idTour, int userId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public TourAdapter(Context context, int userId, AllTourRepository allTourRepository) {
        this.context = context;
        this.userId = userId;
        this.allTourRepository = allTourRepository;
    }

    public void setAllData(List<AllTourModel> listAllTour) {
        this.listAllTour = listAllTour;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        AllTourModel tour = listAllTour.get(position);
        int tourId = tour.getTourId();
        Picasso.get().load(tour.getUrlImg()).error(R.drawable.img_0).into(holder.image);
        holder.tvNameTour.setText(tour.getNameTour());
        holder.tvPriceTour.setText(String.valueOf(tour.getPrice()));

        // Kiểm tra và cập nhật icon yêu thích
        if (tour.isFavorite()) {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Icon đã favorite
        } else {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Icon chưa favorite
        }

        // Xử lý sự kiện khi người dùng ấn vào nút yêu thích
        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tour.isFavorite()) {
                    // Xóa yêu thích
                    allTourRepository.removeFavorite(userId, tourId); // Xóa khỏi cơ sở dữ liệu
                    tour.setFavorite(false); // Cập nhật trạng thái yêu thích của tour trong danh sách hiện tại
                    holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Cập nhật icon
                } else {
                    // Thêm yêu thích
                    allTourRepository.addFavorite(userId, tourId); // Thêm vào cơ sở dữ liệu
                    tour.setFavorite(true); // Cập nhật trạng thái yêu thích của tour trong danh sách hiện tại
                    holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Cập nhật icon
                }
            }
        });

        // Xử lý sự kiện khi người dùng nhấn vào item tour
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(tour.getTourId(), userId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAllTour != null ? listAllTour.size() : 0;
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView tvNameTour;
        private TextView tvPriceTour;
        private ImageView imgFav;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_img_tour);
            tvNameTour = itemView.findViewById(R.id.item_tv_name_tour);
            tvPriceTour = itemView.findViewById(R.id.item_price_tour);
            imgFav = itemView.findViewById(R.id.item_img_favorite);
        }
    }
}
