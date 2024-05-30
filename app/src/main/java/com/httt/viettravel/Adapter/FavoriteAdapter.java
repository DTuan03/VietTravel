package com.httt.viettravel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Favorite;
import com.httt.viettravel.R;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private List<Favorite> mListFavorite;

    public void setData(List<Favorite> list){
        this.mListFavorite = list;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Favorite favorite = mListFavorite.get(position);
        if(favorite != null){
            holder.img.setImageResource(favorite.getResourcImg());
            holder.tvTitle.setText(favorite.getTitle());
            holder.tvAvgStar.setText(favorite.getAvgStar());
            holder.tvPrice.setText(favorite.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        if(mListFavorite != null){
            return mListFavorite.size();
        }
        return 0;
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder{
         private ImageView img;

         private TextView tvTitle;
         private TextView tvAvgStar;
         private TextView tvPrice;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_favorite_img);
            tvTitle = itemView.findViewById(R.id.item_favorite_tv_title);
            tvAvgStar = itemView.findViewById(R.id.item_favorite_tv_avg_star);
            tvPrice = itemView.findViewById(R.id.item_favorite_tv_price);
        }
    }
}
