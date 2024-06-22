package com.httt.viettravel.TabHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Feedback;
import com.httt.viettravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Tab2Adapter extends RecyclerView.Adapter<Tab2Adapter.FeedbackViewHolder> {
    private List<Feedback> feedbackList;
    private Context context;

    public Tab2Adapter(Context context, List<Feedback> feedbackList) {
        this.context = context;
        this.feedbackList = feedbackList;
        notifyDataSetChanged();
    }

    @Override
    public FeedbackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feedback, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedbackViewHolder holder, int position) {
        Feedback feedback = feedbackList.get(position);
        holder.bind(feedback);
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbackList = feedbacks;
    }

    public class FeedbackViewHolder extends RecyclerView.ViewHolder {
        TextView userName, nameTour, date, time, comment;
        RatingBar ratingBar;
        ImageView imgTour;

        public FeedbackViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            nameTour = itemView.findViewById(R.id.nameTour);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
            comment = itemView.findViewById(R.id.cmt);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imgTour = itemView.findViewById(R.id.ImgTour); // Thêm ImageView
        }

        public void bind(Feedback feedback) {
            userName.setText(feedback.getUserName());
            nameTour.setText(feedback.getNameTour()); // Hiển thị NameTour
            date.setText(feedback.getDateOfFeedback());
            time.setText(feedback.getTimeOfFeedback());
            comment.setText(feedback.getDescriptionFeedback());
            ratingBar.setRating(feedback.getRating());
            // Load image using Picasso
            Picasso.get().load(feedback.getImgMainResource()).into(imgTour);

        }
    }
}
