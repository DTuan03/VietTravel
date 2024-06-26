package com.httt.viettravel.History.Rated.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.History.Rated.Model.Rated;
import com.httt.viettravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RatedAdapter extends RecyclerView.Adapter<RatedAdapter.FeedbackViewHolder> {

    private Context context;
    private List<Rated> ratedList;

    public RatedAdapter(Context context, List<Rated> ratedList) {
        this.context = context;
        this.ratedList = ratedList;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rated, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        Rated rated = ratedList.get(position);
        holder.bind(rated);
    }

    @Override
    public int getItemCount() {
        return ratedList.size();
    }

    public void setFeedbacks(List<Rated> ratedList) {
        this.ratedList = ratedList;
    }

    class FeedbackViewHolder extends RecyclerView.ViewHolder {
        TextView userName, tvDate, tvTime, cmt, nameTour;
        RatingBar ratingBar;
        RecyclerView recyclerViewImages;
        ImageView imgTour, imgUser;
        ImageAdapter imageAdapter;

        FeedbackViewHolder(View itemView) {
            super(itemView);
            imgUser =  itemView.findViewById(R.id.img_user_rated);
            userName = itemView.findViewById(R.id.userName_rated);
            tvDate = itemView.findViewById(R.id.tvDate_rated);
            tvTime = itemView.findViewById(R.id.tvTime_rated);
            cmt = itemView.findViewById(R.id.cmt_rated);
            nameTour = itemView.findViewById(R.id.nameTour_rated);
            ratingBar = itemView.findViewById(R.id.ratingBar_rated);
            recyclerViewImages = itemView.findViewById(R.id.recyclerViewImages_rated);
            imgTour = itemView.findViewById(R.id.ImgTour_rated);

            // Initialize ImageAdapter
            imageAdapter = new ImageAdapter(context, null);
            recyclerViewImages.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerViewImages.setAdapter(imageAdapter);
        }

        void bind(Rated rated) {
            userName.setText(rated.getUserName());
            tvDate.setText(rated.getDateOfFeedback());
            tvTime.setText(rated.getTimeOfFeedback());
            cmt.setText(rated.getDescriptionFeedback());
            nameTour.setText(rated.getNameTour());
            ratingBar.setRating(rated.getRating());
            // Load image using Picasso
            Picasso.get().load(rated.getImgMainResource()).into(imgTour);
            // Update images in the ImageAdapter
            imageAdapter.updateImages(rated.getImageUrls());
        }
    }
}
