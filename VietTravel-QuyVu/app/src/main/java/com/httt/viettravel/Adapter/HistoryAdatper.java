package com.httt.viettravel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Favorite;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;

import java.util.List;

public class HistoryAdatper extends RecyclerView.Adapter<HistoryAdatper.HistoryViewHolder> {

    private List<Tour> tours;

    public HistoryAdatper(List<Tour> tours) {
        this.tours = tours;
    }

    public void setData(List<Tour> tours){
        this.tours = tours;
    }

    @NonNull
    @Override
    public HistoryAdatper.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdatper.HistoryViewHolder holder, int position) {
        Tour tour = tours.get(position);
        if(tour == null){
            return;
        }

        holder.pic.setImageResource(tour.getPic());
        holder.location.setText(tour.getLocation());
        holder.price.setText(tour.getPrice());
        holder.time.setText(tour.getTime());
    }

    @Override
    public int getItemCount() {
        return tours.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView content,location, routine,time,price,vehicle,place, comment;
        CardView card;
        Button btn_submit;
        public HistoryViewHolder(@NonNull View itemView) {
                super(itemView);
                pic = itemView.findViewById(R.id.img);
                location = itemView.findViewById(R.id.location);
                price = itemView.findViewById(R.id.price);
                time = itemView.findViewById(R.id.time);
                card = itemView.findViewById(R.id.card);
                btn_submit = itemView.findViewById(R.id.btn_submit);
            }
        }
    }

