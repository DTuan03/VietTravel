package com.example.feedback.Adapter;

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

import com.example.feedback.FeedbackActivity;
import com.example.feedback.MainActivity;
import com.example.feedback.Model.Tour;
import com.example.feedback.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourItemVieHolder> {
    private List<Tour> tours;
    Context context;

    public TourAdapter(List<Tour> tours, Context context) {
        this.tours = tours;
        this.context = context;
    }

    @NonNull
    @Override
    public TourAdapter.TourItemVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourItemVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourAdapter.TourItemVieHolder holder, int position) {
        Tour tour = tours.get(position);

        if(tour == null){
            return;
        }

        holder.pic.setImageResource(tour.getPic());
        holder.location.setText(tour.getLocation());
        holder.price.setText(tour.getPrice());
        holder.time.setText(tour.getTime());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang FeedbackActivity và truyền dữ liệu tour du lịch
                Intent intent = new Intent(context, FeedbackActivity.class);

                intent.putExtra("pic", tour.getPic());
                intent.putExtra("content", tour.getContent());
                intent.putExtra("location", tour.getLocation());
                intent.putExtra("routine", tour.getRoutine());
                intent.putExtra("time", tour.getTime());
                intent.putExtra("price", tour.getPrice());
                intent.putExtra("vehicle", tour.getVehicle());
                intent.putExtra("place", tour.getPlace());
                intent.putExtra("comment", tour.getComment());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(tours != null){
            return tours.size();
        }
        return 0;
    }
    public class TourItemVieHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView content,location, routine,time,price,vehicle,place, comment;
        CardView card;
        public TourItemVieHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.img);
            location = itemView.findViewById(R.id.location);
            price = itemView.findViewById(R.id.price);
            time = itemView.findViewById(R.id.time);
            card = itemView.findViewById(R.id.card);
        }
    }
}
