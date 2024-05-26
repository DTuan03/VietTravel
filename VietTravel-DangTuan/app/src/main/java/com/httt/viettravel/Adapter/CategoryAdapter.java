package com.httt.viettravel.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.CommentTourActivity;
import com.httt.viettravel.Model.Category;
import com.httt.viettravel.Model.Tour;
import com.httt.viettravel.R;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> listCategory;
    private Tour selectedTour;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Category> list) {
        this.listCategory= list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {


        Category category = listCategory.get(position);

        if (category == null) {
            return;
        }
        holder.txtCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rcvTour.setLayoutManager(linearLayoutManager);


        TourAdapter tourAdapter = new TourAdapter();
        tourAdapter.setData(category.getTours());
        holder.rcvTour.setAdapter(tourAdapter);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentTourActivity.class);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategory;
        RecyclerView rcvTour;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategory=itemView.findViewById(R.id.category);
            rcvTour=itemView.findViewById(R.id.cate_rcv_tour);
        }
    }
}


