package com.httt.test.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.test.Model.Voucher;
import com.httt.test.R;
import com.httt.test.ui.home.HomeFragment;

import java.util.List;


public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>{
    private List<Voucher> voucherList;
    private Context context;
    public VoucherAdapter(Context context, List<Voucher> voucherList) {
        this.context = context;
        this.voucherList = voucherList;
    }

    @NonNull
    @Override
    public VoucherAdapter.VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_voucher, parent, false);
        return new VoucherAdapter.VoucherViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return voucherList != null ? voucherList.size() : 0;
    }

    public static class VoucherViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDescription;
        public ImageView imgVoucher;
        public Button btnSave;

        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_voucher);
            tvDescription = itemView.findViewById(R.id.tv_description_voucher);
            imgVoucher = itemView.findViewById(R.id.img_voucher);
            btnSave = itemView.findViewById(R.id.btn_saveVoucher);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherAdapter.VoucherViewHolder holder, int position) {
        Voucher voucher = voucherList.get(position);
        if (voucher != null) {
            holder.tvTitle.setText(voucher.getTv_title_voucher());
            holder.tvDescription.setText(voucher.getTv_description_voucher());
            holder.imgVoucher.setImageURI(Uri.parse(voucher.getImg_voucher()));
            holder.btnSave.setOnClickListener(v -> {
//                favouriteTour.addFavTour(tour);
                Toast.makeText(context,"Save voucher: "+ voucher.getTv_title_voucher(), Toast.LENGTH_LONG).show();
            });
        }
    }
}