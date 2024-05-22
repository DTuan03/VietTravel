package com.example.edit_info.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edit_info.Domain.TourItem;
import com.example.edit_info.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourItemViewHolder> {
    private List<TourItem> tour;

    public TourAdapter(List<TourItem> tourItems) {
        this.tour= tourItems;
    }

    @NonNull
    @Override
    public TourItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new TourItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourItemViewHolder holder, int position) {
        TourItem tourItem = tour.get(position);
        holder.imageView.setImageResource(tourItem.getPic());
        holder.textView.setText(tourItem.getLocation());
    }

    @Override
    public int getItemCount() {
        return tour.size();
    }

    static class TourItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public TourItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}