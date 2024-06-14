package com.httt.viettravel.TabHistory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Adapter.HistoryAdatper;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;
import com.httt.viettravel.ReviewActivity;

import java.util.ConcurrentModificationException;
import java.util.List;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.Tab1ViewHolder> {


    private List<Tour> tours;
    private Context context;

    public Tab1Adapter(List<Tour> tours, Context context) {
        this.tours = tours;
        this.context = context;
    }

    public void setData(List<Tour> tours){
        this.tours = tours;
    }

    @NonNull
    @Override
    public Tab1Adapter.Tab1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new Tab1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab1Adapter.Tab1ViewHolder holder, int position) {
        Tour tour = tours.get(position);
        if(tour == null){
            return;
        }

        holder.pic.setImageResource(tour.getPic());
        holder.location.setText(tour.getLocation());
        holder.price.setText(tour.getPrice());
        holder.time.setText(tour.getTime());

        holder.btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang FeedbackActivity và truyền dữ liệu tour du lịch
                Intent intent = new Intent(context, ReviewActivity.class);
                intent.putExtra("pic", tour.getPic());
                intent.putExtra("content", tour.getContent());
                intent.putExtra("location", tour.getLocation());
                intent.putExtra("routine", tour.getRoutine());
                intent.putExtra("time", tour.getTime());
                intent.putExtra("price", tour.getPrice());
                intent.putExtra("vehicle", tour.getVehicle());
                intent.putExtra("place", tour.getPlace());
//                intent.putExtra("comment", tour.getComment());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return tours.size();
    }

    public class Tab1ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView content,location, routine,time,price,vehicle,place, comment;
        CardView card;
        Button btn_comment;
        public Tab1ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.img);
            location = itemView.findViewById(R.id.location);
            price = itemView.findViewById(R.id.price);
            time = itemView.findViewById(R.id.time);
            card = itemView.findViewById(R.id.card);
            btn_comment = itemView.findViewById(R.id.btn_comment);

        }
    }
}
