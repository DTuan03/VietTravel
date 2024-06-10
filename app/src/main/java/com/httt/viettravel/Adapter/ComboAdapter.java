package com.httt.viettravel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Combo;
import com.httt.viettravel.R;

import java.util.List;

public class ComboAdapter extends RecyclerView.Adapter<ComboAdapter.ComboViewHolder> {
    private List<Combo> mListCombo;

    public void setData(List<Combo> list){
        this.mListCombo = list;
    }
    @NonNull
    @Override
    public ComboViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_combo,parent,false);
        return new ComboViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComboViewHolder holder, int position) {
        Combo combo = mListCombo.get(position);
        if(combo != null){
            holder.img.setImageResource(combo.getResourceId());
            holder.tvTitle.setText(combo.getTitle());
            holder.tvPrice.setText(combo.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        if(mListCombo != null){
            return mListCombo.size();
        }
        return 0;
    }

    public class ComboViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle;

        private TextView tvPrice;
        public ComboViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_combo_img);
            tvTitle = itemView.findViewById(R.id.item_combo_tv);
            tvPrice = itemView.findViewById(R.id.item_combo_price);
        }
    }
}
