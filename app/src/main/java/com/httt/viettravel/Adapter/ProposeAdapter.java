package com.httt.viettravel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Propose;
import com.httt.viettravel.R;

import java.util.List;

public class ProposeAdapter extends RecyclerView.Adapter <ProposeAdapter.ProposeViewHolder>{

    private List<Propose> mListproposes;

    @NonNull
    @Override
    public ProposeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_propose, parent, false);
        return new ProposeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProposeViewHolder holder, int position) {
        Propose propose = mListproposes.get(position);
        if(propose != null){
            holder.img.setImageResource(propose.getResourceId());
            holder.title.setText(propose.getTitle());
            holder.numberStar.setText(propose.getNumberStar());
            holder.price.setText(propose.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        if(mListproposes != null){
            return mListproposes.size();
        }
        return 0;
    }

    public class ProposeViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title, numberStar;
        private TextView price;
        public ProposeViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_propose_img);
            title = itemView.findViewById(R.id.item_propose_tv_title);
            numberStar = itemView.findViewById(R.id.item_propose_tv_number_star);
            price = itemView.findViewById(R.id.item_propose_price);
        }
    }
}
