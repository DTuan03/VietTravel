package com.httt.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Model.Tour;
import com.httt.test.Model.Voucher;
import com.httt.test.R;

import java.util.ArrayList;
import java.util.List;


public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>{

//    private ArrayList<Voucher> vouchers ;
//    private Context mContext;
//    public VoucherAdapter(Context context, ArrayList<Voucher> vouchers) {
//        this.mContext = context;
//        this.vouchers = vouchers;
//    }
//
//    @NonNull
//    @Override
//    public VoucherAdapter.VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem = layoutInflater.inflate(R.layout.item_voucher, parent, false);
//        return new VoucherViewHolder(listItem);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull VoucherAdapter.VoucherViewHolder holder, int position) {
//        final  Voucher v = vouchers.get(position);
//        String NameTour = String.valueOf(v.getTv_name_tour());
//        holder.tvNameTour.setText(NameTour);
//        holder.tvPrice.setText(""+v.getTv_price());
//        holder.imgTour.setImageURI(v.getImg_tour());
//        holder.tvFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addButtonClick(view, v);
//            }
//        });
//    }
//
//    private void addButtonClick(View view, Voucher t) {
////        Toast.makeText(view.getContext(),"click on item: "+ p.getName(), Toast.LENGTH_LONG).show();
//        vouchers.add(t);
//    }
//
//    @Override
//    public int getItemCount() {
//        return vouchers.size();
//    }
//
//    public class VoucherViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView tvNameTour;
//        public TextView tvDescription;
//        public TextView tvPrice;
//        public TextView tvFav;
//        public ImageView imgTour;
//
//        public VoucherViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.tvNameTour = itemView.findViewById(R.id.tv_title);
//            this.tvDescription = itemView.findViewById(R.id.tv_description);
//            this.tvPrice = itemView.findViewById(R.id.tv_price);
//            this.tvFav = itemView.findViewById(R.id.tv_fav);
//            this.imgTour = itemView.findViewById(R.id.img_tour);
//        }
//    }

    private List<Voucher> mListVoucher;

    public VoucherAdapter(List<Voucher> mListVoucher) {
        this.mListVoucher = mListVoucher;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VoucherAdapter.VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_voucher, parent, false);
        VoucherAdapter.VoucherViewHolder voucherViewHolder = new VoucherAdapter.VoucherViewHolder(listItem);
        return voucherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherAdapter.VoucherViewHolder holder, int position) {
        Voucher voucher = mListVoucher.get(position);
        if (voucher == null){
            return;
        }
        holder.imgVoucher.setImageResource(voucher.getImg_voucher());
        holder.tvNameVoucher.setText(voucher.getTv_title_voucher());
        holder.tvDescriptionVoucher.setText(voucher.getTv_description_voucher());
    }

    @Override
    public int getItemCount() {
        return mListVoucher != null ? mListVoucher.size() : 0;
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgVoucher;
        public TextView tvNameVoucher;
        public TextView tvDescriptionVoucher;
        public Button btnSaveVoucher;

        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgVoucher = itemView.findViewById(R.id.img_voucher);
            this.tvNameVoucher = itemView.findViewById(R.id.tv_title_voucher);
            this.tvDescriptionVoucher = itemView.findViewById(R.id.tv_description_voucher);
            this.btnSaveVoucher = itemView.findViewById(R.id.btn_saveVoucher);
        }
    }
}