package com.httt.viettravel.TabHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.httt.viettravel.R;
import com.httt.viettravel.Model.Tour;
import java.util.List;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.TourViewHolder> {
    private List<Tour> tourList;
    private Context context;

    public Tab1Adapter(Context context, List<Tour> tourList) {
        this.context = context;
        this.tourList = tourList;
    }

    @Override
    public TourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        holder.bind(tour);
    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public void setTours(List<Tour> tours) {
        this.tourList = tours;
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {
        TextView nameTour;
        TextView numberDay;
        TextView totalTour;
        Button rateButton;

        public TourViewHolder(View itemView) {
            super(itemView);
            nameTour = itemView.findViewById(R.id.NameTour);
            numberDay = itemView.findViewById(R.id.NumberDay);
           totalTour = itemView.findViewById(R.id.TotalTour);
            rateButton = itemView.findViewById(R.id.btn_rate);
        }

        public void bind(Tour tour) {
            nameTour.setText(tour.getNameTour());
            numberDay.setText(String.valueOf(tour.getNumberDay()));
            totalTour.setText(String.valueOf(tour.getTotal()));
            // Thêm xử lý cho nút rateButton nếu cần
        }
    }
}












//package com.httt.viettravel.TabHistory;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
////import com.httt.viettravel.Adapter.HistoryAdatper;
//import com.httt.viettravel.Model.Tour;
//import com.httt.viettravel.R;
//import com.httt.viettravel.ReviewActivity;
//
//import java.util.ConcurrentModificationException;
//import java.util.List;
//
//public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.Tab1ViewHolder> {
//
//
//    private List<Tour> tours;
//    private Context context;
//
//
//    public Tab1Adapter(Context context, List<Tour> tourList) {
//        this.context = context;
//        this.tours = tourList;
//    }
//
////    public void setData(List<Tour> tours){
////        this.tours = tours;
////    }
//
//    @NonNull
//    @Override
//    public Tab1Adapter.Tab1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
//        return new Tab1ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Tab1Adapter.Tab1ViewHolder holder, int position) {
//        Tour tour = tours.get(position);
//        if(tour == null){
//            return;
//        }
//        holder.bind(tour);
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return tours.size();
//    }
//
//    public void setTours(List<Tour> tours) {
//        this.tours = tours;
//    }
//
//
//    public class Tab1ViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTour;
//        TextView numberDay;
//        TextView priceTour;
//        Button rateButton;
//
//        public Tab1ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTour = itemView.findViewById(R.id.NameTour);
//            numberDay = itemView.findViewById(R.id.NumberDay);
//            priceTour = itemView.findViewById(R.id.PriceTour);
//            rateButton = itemView.findViewById(R.id.btn_rate);
//
//        }
//
//        public void bind(Tour tour) {
//            nameTour.setText(tour.getNameTour());
//            numberDay.setText(String.valueOf(tour.getNumberDay()));
//            priceTour.setText(String.valueOf(tour.getPriceTour()));
//            // Thêm xử lý cho nút rateButton nếu cần
//        }
//    }
//}
