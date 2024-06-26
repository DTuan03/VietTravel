package com.httt1.vietnamtravel.Feedback.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.Feedback.Model.Feedback;
import com.httt1.vietnamtravel.R;
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
        holder.userName.setText(feedback.getUserName());
        holder.comment.setText(feedback.getDescriptionFeedback());
        holder.ratingBar.setRating(feedback.getRating());
        holder.date.setText(feedback.getDateOfFeedback());
        holder.time.setText(feedback.getTimeOfFeedback());
        holder.tourName.setText(feedback.getNameTour());
        Picasso.get().load(feedback.getImgMainResource()).into(holder.tourImage);
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbackList = feedbacks;
        notifyDataSetChanged();
    }

    static class FeedbackViewHolder extends RecyclerView.ViewHolder {
        TextView userName, comment, date, time, tourName;
        RatingBar ratingBar;
        ImageView tourImage;

        public FeedbackViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName_feedback);
            comment = itemView.findViewById(R.id.cmt_feedback);
            ratingBar = itemView.findViewById(R.id.ratingBar_feedback);
            date = itemView.findViewById(R.id.tvDate_feedback);
            time = itemView.findViewById(R.id.tvTime_feedback);
            tourName = itemView.findViewById(R.id.nameTour_feedback);
            tourImage = itemView.findViewById(R.id.ImgTour_feedback);
        }
    }
}
