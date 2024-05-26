package com.httt.viettravel;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.httt.viettravel.Model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvVoucher;
    private VoucherAdapter voucherAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Khai bao MyArrayAdapter
        voucherAdapter = new VoucherAdapter();
        rcvVoucher = findViewById(R.id.activity_main_rcv);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvVoucher.setLayoutManager(linearLayoutManager);

        voucherAdapter.setData(getListVoucher());

        rcvVoucher.setAdapter(voucherAdapter);
        //Gan  ArrAdapter vao cho ListView
    }

    private List<Voucher> getListVoucher(){
        List<Voucher> list = new ArrayList<>();
        list.add(new Voucher(R.mipmap.ic_launcher_logo));
        Log.d("sss", "ssss");
        list.add(new Voucher(R.drawable.img));
        list.add(new Voucher(R.mipmap.ic_launcher_logo));
        list.add(new Voucher(R.mipmap.ic_launcher_logo));
        list.add(new Voucher(R.mipmap.ic_launcher_logo));

        return list;
    }
}