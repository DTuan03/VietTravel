package com.httt.viettravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Voucher;

import java.util.List;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder> {
    private List<Voucher> mListVocher;

    public void setData(List<Voucher> list){
        this.mListVocher = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_item,parent,false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewHolder holder, int position) {
        Voucher voucher = mListVocher.get(position);
        if(voucher != null){
            return;
        }
        holder.imgVoucher.setImageResource(voucher.getmResourceId());
    }

    @Override
    public int getItemCount() {
        if(mListVocher != null){
            return mListVocher.size();
        }
        return 0;
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgVoucher;
        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVoucher = itemView.findViewById(R.id.voucher_item_img);
        }
    }
}