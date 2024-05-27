package com.httt.viettravel.Adapter;//package com.httt.viettravel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.CommentTourActivity;
import com.httt.viettravel.Model.CommentTour;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;

import java.util.List;

public class CommentTourApdapter extends RecyclerView.Adapter<CommentTourViewHolder> {
    private Context context;
    private List<CommentTour> commentTours;

    public CommentTourApdapter(Context context, List<CommentTour> commentTours) {
        this.context = context;
        this.commentTours = commentTours;
    }
    public void setData(List<CommentTour> commentTours) {
        this.commentTours=commentTours;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentTourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_comment_tour, parent, false);
        return new CommentTourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentTourViewHolder holder, int position) {
        holder.pic.setImageResource(commentTours.get(position).getPic());
        holder.content.setText(commentTours.get(position).getContent());
        holder.location.setText(commentTours.get(position).getLocation());
        holder.routine.setText(commentTours.get(position).getRoutine());
        holder.time.setText(commentTours.get(position).getTime());
        holder.price.setText(commentTours.get(position).getPrice());
        holder.vehicle.setText(commentTours.get(position).getVehicle());
        holder.place.setText(commentTours.get(position).getPlace());
        holder.comment.setText(commentTours.get(position).getComment());

    }

    @Override
    public int getItemCount() {
        return commentTours.size();
    }


}

    class CommentTourViewHolder extends RecyclerView.ViewHolder{

        ImageView pic;
        TextView content,location, routine,time,price,vehicle,place, comment;
        public CommentTourViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.img);
            content = itemView.findViewById(R.id.content);
            routine = itemView.findViewById(R.id.routine);
            location = itemView.findViewById(R.id.location);
            time = itemView.findViewById(R.id.time);
            price = itemView.findViewById(R.id.price);
            vehicle = itemView.findViewById(R.id.vehivle);
            place = itemView.findViewById(R.id.place);
            comment = itemView.findViewById(R.id.comment);
        }
    }




