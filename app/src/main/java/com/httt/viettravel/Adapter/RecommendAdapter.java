package com.httt.viettravel.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.R;

public class RecommendAdapter {

    public class RecommentAdapter extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        private TextView numberStar;
        private TextView price;
        public RecommentAdapter(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item)
        }
    }
}
