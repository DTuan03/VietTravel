package com.httt.viettravel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Guide;
import com.httt.viettravel.R;

import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {
    private List<Guide> guideList;

    public void setData(List<Guide> list){
        this.guideList = list;
    }

    @NonNull
    @Override
    public GuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide, parent, false);
        return new GuideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideViewHolder holder, int position) {
        Guide guide = guideList.get(position);
        if (guide != null){
            holder.img.setImageResource(guide.getIdResouce());
            holder.title.setText(guide.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if (guideList != null){
            return guideList.size();
        }
        return 0;
    }

    public class GuideViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public GuideViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_guide_img);
            title = itemView.findViewById(R.id.item_guide_tv);
        }
    }
}
