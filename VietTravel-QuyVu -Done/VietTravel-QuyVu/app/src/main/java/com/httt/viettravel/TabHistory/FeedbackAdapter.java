package com.httt.viettravel.TabHistory;

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

import com.httt.viettravel.Model.Feedback;
import com.httt.viettravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder> {

    private Context context;
    private List<Feedback> feedbackList;

    public FeedbackAdapter(Context context, List<Feedback> feedbackList) {
        this.context = context;
        this.feedbackList = feedbackList;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feedback, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        Feedback feedback = feedbackList.get(position);
        holder.bind(feedback);
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public void setFeedbacks(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    class FeedbackViewHolder extends RecyclerView.ViewHolder {
        TextView userName, tvDate, tvTime, cmt, nameTour;
        RatingBar ratingBar;
        RecyclerView recyclerViewImages;
        ImageView imgTour;

        FeedbackViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName_feedback);
            tvDate = itemView.findViewById(R.id.tvDate_feedback);
            tvTime = itemView.findViewById(R.id.tvTime_feedback);
            cmt = itemView.findViewById(R.id.cmt_feedback);
            nameTour = itemView.findViewById(R.id.nameTour_feedback);
            ratingBar = itemView.findViewById(R.id.ratingBar_feedback);
            recyclerViewImages = itemView.findViewById(R.id.recyclerViewImages_feedback);
            imgTour = itemView.findViewById(R.id.ImgTour_feedback);
        }

        void bind(Feedback feedback) {
            userName.setText(feedback.getUserName());
            tvDate.setText(feedback.getDateOfFeedback());
            tvTime.setText(feedback.getTimeOfFeedback());
            cmt.setText(feedback.getDescriptionFeedback());
            nameTour.setText(feedback.getNameTour());
            ratingBar.setRating(feedback.getRating());

            if (imgTour != null) {
                Picasso.get().load(feedback.getImgMainResource()).into(imgTour);
            }

            recyclerViewImages.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            ImageAdapter imageAdapter = new ImageAdapter(context, feedback.getImageUrls());
            recyclerViewImages.setAdapter(imageAdapter);
        }
    }
}
