package com.httt1.vietnamtravel.home.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.model.HomeRepository;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComboAdapter extends RecyclerView.Adapter<ComboAdapter.ComboViewHolder> {
    private List<HomeModel> listCombo;
    private Context context;
    private int userId;
    private HomeRepository homeRepository;
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(int idTour, int idUser);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public ComboAdapter(Context context, int userId, HomeRepository homeRepository) {
        this.context = context;
        this.userId = userId;
        this.homeRepository = homeRepository;
    }
    public void setDataCombo(Context context, List<HomeModel> listCombo){
        this.context = context;
        this.listCombo = listCombo;
    }
    @NonNull
    @Override
    public ComboViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_combo, parent, false);
        return new ComboViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComboViewHolder holder, int position) {
        HomeModel combo = listCombo.get(position);
        String tourId = combo.gettourId();
        String uriImgCombo = combo.geturlImg();
        String tvNameTour = combo.getnameTour();
        int tvPriceTour = combo.getPrice();
            //placeholder để đặt hình ảnh mặc định khi đang tải và error() để đặt hình ảnh mặc định khi xảy ra lỗi khi tải ảnh
        Picasso.get().load(uriImgCombo).error(R.drawable.hue5).into(holder.image);
        holder.tvNameToure.setText(tvNameTour);
        holder.tvPriceToure.setText(String.valueOf(tvPriceTour));


        // Xử lý sự kiện khi người dùng ấn vào nút yêu thích
        holder.imgFav.setOnClickListener(v -> {
            if (combo.getIsFavorite() == 1) {
                // Xóa yêu thích
                homeRepository.removeFavorite(userId, Integer.parseInt(tourId)); // Xóa khỏi cơ sở dữ liệu
                combo.setIsFavorite(0); // Cập nhật trạng thái yêu thích của tour trong danh sách hiện tại
                holder.imgFav.setImageResource(R.mipmap.activity_home_favorite); // Cập nhật icon
            } else {
                // Thêm yêu thích
                homeRepository.addFavorite(userId, Integer.parseInt(tourId)); // Thêm vào cơ sở dữ liệu
                combo.setIsFavorite(1); // Cập nhật trạng thái yêu thích của tour trong danh sách hiện tại
                holder.imgFav.setImageResource(R.mipmap.icon_favorite_color); // Cập nhật icon
            }
        });

        if(combo.getIsFavorite() != 0){
            holder.imgFav.setImageResource(R.mipmap.icon_favorite_color);
        }
        // Thêm sự kiện click vào item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(Integer.parseInt(tourId), userId);
                }
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

    public class ComboViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView tvNameToure;
        private TextView tvPriceToure;
        private ImageView imgFav;
        public ComboViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_combo_img);
            tvNameToure = itemView.findViewById(R.id.item_combo_tv_name_tour);
            tvPriceToure = itemView.findViewById(R.id.item_combo_price_tour);
            imgFav = itemView.findViewById(R.id.item_combo_img_favorite);
        }
    }

}
