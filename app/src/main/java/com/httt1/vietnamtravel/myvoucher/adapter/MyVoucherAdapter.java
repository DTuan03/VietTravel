package com.httt1.vietnamtravel.myvoucher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.myvoucher.model.MyVoucherModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyVoucherAdapter extends RecyclerView.Adapter<MyVoucherAdapter.MyvoucherViewHolder> {

    List<MyVoucherModel> listMyVoucher;
    public void setDataMyVoucher(List<MyVoucherModel> listMyVoucher){
        this.listMyVoucher = listMyVoucher;
    }
    @NonNull
    @Override
    public MyvoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_voucher, parent, false);
        return new MyvoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyvoucherViewHolder holder, int position) {
        MyVoucherModel myVoucher = listMyVoucher.get(position);
        String imgUrl = myVoucher.getImgUrl();
        String title = myVoucher.getTitle();
        String descrip = myVoucher.getDesdrip();
        if (myVoucher != null){
            //placeholder để đặt hình ảnh mặc định khi đang tải và error() để đặt hình ảnh mặc định khi xảy ra lỗi khi tải ảnh
            Picasso.get().load(imgUrl).error(R.drawable.hue5).into(holder.img);
            holder.tvTitle.setText(title);
            holder.tvDescrip.setText(String.valueOf(descrip));
        }
    }

    @Override
    public int getItemCount() {
        if(listMyVoucher != null){
            return listMyVoucher.size();
        }
        return 0;
    }

    public class MyvoucherViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvTitle, tvDescrip;
        public MyvoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_myvoucher_img);
            tvTitle = itemView.findViewById(R.id.item_myvoucher_tv_title);
            tvDescrip = itemView.findViewById(R.id.item_myvoucher_tv_descrip);
        }
    }
}
