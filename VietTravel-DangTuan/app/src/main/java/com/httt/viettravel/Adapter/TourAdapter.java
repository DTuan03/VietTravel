package com.httt.viettravel.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.httt.viettravel.CommentTourActivity;
import com.httt.viettravel.Model.Tour;

import com.httt.viettravel.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourItemViewHolder> {

    private List<Tour> tours;

    public void setData(List<Tour> tours) {
        this.tours=tours;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourAdapter.TourItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourAdapter.TourItemViewHolder holder, int position) {
        Tour tourItem = tours.get(position);
        if(tourItem == null){
            return;
        }

        holder.imageView.setImageResource(tourItem.getPic());
        holder.location.setText(tourItem.getLocation());
        holder.price.setText(tourItem.getPrice());
        holder.day.setText(tourItem.getDay());





    }



    @Override
    public int getItemCount() {
        if(tours != null){
            return tours.size();
        }
        return 0;
    }


    public class TourItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView location;
        TextView price;
        TextView day;

        public TourItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.img);
            location =itemView.findViewById(R.id.location);
            price =itemView.findViewById(R.id.price);
            day =itemView.findViewById(R.id.day);
        }
    }
}
