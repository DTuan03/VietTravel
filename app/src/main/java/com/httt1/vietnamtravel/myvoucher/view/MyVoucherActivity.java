package com.httt1.vietnamtravel.myvoucher.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.common.utils.SharedPrefsHelper;
import com.httt1.vietnamtravel.home.adapter.ComboAdapter;
import com.httt1.vietnamtravel.myvoucher.adapter.MyVoucherAdapter;
import com.httt1.vietnamtravel.myvoucher.model.MyVoucherModel;
import com.httt1.vietnamtravel.myvoucher.presenter.MyVoucherContract;
import com.httt1.vietnamtravel.myvoucher.presenter.MyVoucherPresenter;

import java.util.List;

public class MyVoucherActivity extends AppCompatActivity implements MyVoucherContract.View {
    private RecyclerView rcvMyVoucher;
    private MyVoucherAdapter myVoucherAdapter;
    private MyVoucherPresenter myVoucherPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_voucher);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(this); //requireContext tuong tu getContext() nhung neu null no se tra ra loi...
        int userId = sharedPrefsHelper.getInt("UserId");

        myVoucherPresenter = new MyVoucherPresenter(this);

        setMyVoucherAdapter(userId);
    }

    private void init(){
        rcvMyVoucher = findViewById(R.id.activity_my_voucher_rcv);
    }

    private void setMyVoucherAdapter(int userId ){
        myVoucherAdapter = new MyVoucherAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvMyVoucher.setLayoutManager(linearLayoutManager);
        rcvMyVoucher.setAdapter(myVoucherAdapter);

        myVoucherPresenter.getDataMyVoucher(userId);
    }
    @Override
    public void showDataMyVoucher(List<MyVoucherModel> list) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Cập nhật dữ liệu vào adapter và RecyclerView
                myVoucherAdapter.setDataMyVoucher(list);
            }
        });
    }
}