package com.httt1.vietnamtravel.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.home.model.HomeModel;
import com.httt1.vietnamtravel.home.presenter.HomeContract;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder> {
    List<HomeModel> listVoucher;
    Context context;
    private HomeContract.clickVoucher clickVoucher;
    public void setDataVoucher(Context context, List<HomeModel> listVoucher, HomeContract.clickVoucher clickVoucher){
        this.context = context;
        this.listVoucher = listVoucher;
        this.clickVoucher = clickVoucher;
    }
    @NonNull
    @Override
    public VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewHolder holder, int position) {
        HomeModel voucher = listVoucher.get(position);
        int voucherId = voucher.getVoucherId();
        String url = voucher.geturlImg();
        if(voucher != null){
            Picasso.with(context).load(url).error(R.drawable.hue5).into(holder.imgVoucher);
        }
        holder.imgVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickVoucher.saveVoucher(voucherId);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listVoucher != null){
            return listVoucher.size();
        }
        return 0;
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgVoucher;
        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVoucher = itemView.findViewById(R.id.item_voucher_img);
        }
    }
}
