package com.httt.viettravel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Recommend;
import com.httt.viettravel.R;

import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter <RecommendAdapter.RecommentViewHolder> {
    private List<Recommend> recommendList;

    public void setData(List<Recommend> list){
        this.recommendList = list;
    }
    @NonNull
    @Override
    public RecommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
        return new RecommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommentViewHolder holder, int position) {
        Recommend recommend = recommendList.get(position);
        if (recommend != null){
            holder.img.setImageResource(recommend.getResourceId());
            holder.title.setText(recommend.getTitle());
            holder.numberStar.setText(recommend.getNumberStar());
            holder.price.setText(recommend.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        if (recommendList != null){
            return recommendList.size();
        }
        return 0;
    }

    public class RecommentViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        private TextView numberStar;
        private TextView price;
        public RecommentViewHolder (@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_recommend_img);
            title = itemView.findViewById(R.id.item_recommend_tv_title);
            numberStar = itemView.findViewById(R.id.item_recommend_tv_number_star);
            price = itemView.findViewById(R.id.item_recommend_price);
        }
    }
}
