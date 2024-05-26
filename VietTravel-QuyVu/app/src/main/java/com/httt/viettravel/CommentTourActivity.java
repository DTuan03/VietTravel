package com.httt.viettravel;//package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

//import com.httt.viettravel.Adapter.CommentTourApdapter;
//import com.httt.viettravel.Model.CommentTour;

import java.util.ArrayList;
import java.util.List;

public class CommentTourActivity extends AppCompatActivity {

//    ImageView pic;
//    TextView content,location, routine,time,price,vehicle,place;
//    List<CommentTour> listCMtour;
//    CommentTour dataCM;

//    CommentTourApdapter commentTourApdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_tour);
        LinearLayout layout_comment = findViewById(R.id.layout_comment);
//
//        initView();
//        setVirable();
    }

//    private void setVirable() {
//
//
//    }
//
//    private void initView() {
//        content = findViewById(R.id.content);
//        routine = findViewById(R.id.routine);
//        location = findViewById(R.id.location);
//        time = findViewById(R.id.time);
//        price = findViewById(R.id.price);
//        vehicle = findViewById(R.id.vehivle);
//        place = findViewById(R.id.place);
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_comment_tour);
//
//        listCMtour = new ArrayList<>();
//
//        dataCM = new CommentTour(R.drawable.halong,"Địa trung hải ", "Hà Nội - Quảng Ninh","Đi tham quan các vịnh lớn nhỏ",
//                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh");
//        listCMtour.add(dataCM);
//
//        dataCM = new CommentTour(R.drawable.sapa,"Đỉnh phan xi păng", "Hà Nội - Lào Cai","Đi tham quan các vịnh lớn nhỏ",
//                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh");
//        listCMtour.add(dataCM);
//
//        dataCM = new CommentTour(R.drawable.halong,"Địa trung hải ", "Hà Nội - Quảng Ninh","Đi tham quan các vịnh lớn nhỏ",
//                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh");
//        listCMtour.add(dataCM);
//        commentTourApdapter  =new CommentTourApdapter(CommentTourActivity.this, listCMtour);
//    }

}