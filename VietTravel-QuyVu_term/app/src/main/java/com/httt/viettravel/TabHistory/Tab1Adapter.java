package com.httt.viettravel.TabHistory;

import android.content.Context;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Adapter.HistoryAdatper;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;
import com.httt.viettravel.ReviewActivity;

import java.util.ConcurrentModificationException;
import java.util.List;
import android.os.Bundle;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.Tab1ViewHolder> {


    private List<Tour> tours;
    private Context context;

    public Tab1Adapter(List<Tour> tours, Context context) {
        this.tours = tours;
        this.context = context;
    }

//    private OnItemClickListener listener;
//
//    public interface OnItemClickListener {
//        void onItemClick(Tour tour);
//    }


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

//        holder.btn_comment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Tạo một instance của ReviewFragment
//                ReviewFragment reviewFragment = new ReviewFragment();
//
//                // Nếu cần truyền dữ liệu từ Tab1 sang ReviewFragment, bạn có thể sử dụng Bundle để đính kèm dữ liệu vào Fragment.
//                // Ví dụ:
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("tour", tour);
//                reviewFragment.setArguments(bundle);
//
//                // Thực hiện chuyển Fragment bằng cách thêm và replace ReviewFragment trong FragmentManager.
//                FragmentManager fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, reviewFragment)
//                        .addToBackStack(null) // Để quay lại Tab1 khi nhấn nút back
//                        .commit();
//            }
//        });
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
