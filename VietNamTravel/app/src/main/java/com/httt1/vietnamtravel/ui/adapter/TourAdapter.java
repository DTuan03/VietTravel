package com.httt1.vietnamtravel.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.ui.model.AllTourRepository;
import com.httt1.vietnamtravel.ui.model.HomeRepository;
import com.httt1.vietnamtravel.ui.model.TourModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {
    private List<TourModel> listCombo;
    private Context context;
    private int userId;
    private HomeRepository homeRepository;
    private AllTourRepository allTourRepository;

    public TourAdapter(Context context, int userId, HomeRepository homeRepository) {
        this.context = context;
        this.userId = userId;
        this.homeRepository = homeRepository;
    }

    public TourAdapter(Context context, int userId, AllTourRepository allTourRepository) {
        this.context = context;
        this.userId = userId;
        this.allTourRepository = allTourRepository;
    }

    public void setDataCombo(Context context, List<TourModel> listCombo){
        this.context = context;
        this.listCombo = listCombo;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        TourModel combo = listCombo.get(position);
        String uriImgCombo = combo.getUrlImg();
        String tvNameTour = combo.getNameTour();
        int tvPriceTour = combo.getPrice();

        Picasso.with(context).load(uriImgCombo).error(R.drawable.img_0).into(holder.image);
        holder.tvNameToure.setText(tvNameTour);
        holder.tvPriceToure.setText(String.valueOf(tvPriceTour));

        // Kiểm tra và cập nhật icon yêu thích
        if (combo.isFavorite()) {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Icon đã favorite
        } else {
            holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Icon chưa favorite
        }

        // Xử lý sự kiện khi người dùng ấn vào nút yêu thích
        holder.imgFav.setOnClickListener(v -> {
            if (combo.isFavorite()) {
                // Xóa yêu thích
                homeRepository.removeFavorite(userId, combo.getTourId());
                allTourRepository.removeFavorite(userId, combo.getTourId());
                combo.setIsFavorite(false); // Cập nhật trạng thái yêu thích của tour
                holder.imgFav.setImageResource(R.drawable.baseline_favorite_border_24); // Cập nhật icon
            } else {
                // Thêm yêu thích
                homeRepository.addFavorite(userId, combo);
                allTourRepository.addFavorite(userId, combo);
                combo.setIsFavorite(true); // Cập nhật trạng thái yêu thích của tour
                holder.imgFav.setImageResource(R.drawable.baseline_favorite_24); // Cập nhật icon
            }
        });
    }


    @Override
    public int getItemCount() {
        if(listCombo != null){
            return listCombo.size();
        }
        return 0;
    }

    public class TourViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView tvNameToure;
        private TextView tvPriceToure;
        private ImageView imgFav;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_img_tour);
            tvNameToure = itemView.findViewById(R.id.item_tv_name_tour);
            tvPriceToure = itemView.findViewById(R.id.item_price_tour);
            imgFav = itemView.findViewById(R.id.item_img_favorite);
        }
    }
}
