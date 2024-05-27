package com.httt.viettravel;//package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.httt.viettravel.Adapter.CommentTourApdapter;
import com.httt.viettravel.Model.CommentTour;
import com.httt.viettravel.Model.Tour;

import java.util.ArrayList;
import java.util.List;

public class CommentTourActivity extends AppCompatActivity {
    private Context context;
   private ImageView pic;
   private TextView content,location, routine,time,price,vehicle,place,comment;
   private CommentTour commentTour;
   private List<CommentTour>  commentTours;
    CommentTourApdapter commentTourApdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_tour);

        commentTours = new ArrayList<>();
        commentTour = new CommentTour(R.drawable.halong,"Địa trung hải ", "Hà Nội - Quảng Ninh","Đi tham quan các vịnh lớn nhỏ",
                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh",null);
        commentTours.add(commentTour);
        commentTour = new CommentTour(R.drawable.sapa,"Địa trung hải ", "Hà Nội - Quảng Ninh","Đi tham quan các vịnh lớn nhỏ",
                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh",null);
        commentTours.add(commentTour);
        commentTour = new CommentTour(R.drawable.sapa,"Địa trung hải ", "Hà Nội - Quảng Ninh","Đi tham quan các vịnh lớn nhỏ",
                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh",null);
        commentTours.add(commentTour);
        commentTour = new CommentTour(R.drawable.halong,"Địa trung hải ", "Hà Nội - Quảng Ninh","Đi tham quan các vịnh lớn nhỏ",
                "2 ngày 1 đêm","VND 2.345.443","Ô tô", "Khách sạn Mường Thanh",null);
        commentTours.add(commentTour);


        initView();
        setVariable();

        commentTourApdapter  =new CommentTourApdapter(CommentTourActivity.this, commentTours);
    }






    private void setVariable() {
        commentTour = (CommentTour) getIntent().getSerializableExtra("tour");

        pic.setImageResource(commentTour != null ? commentTour.getPic() : 0);
        content.setText(commentTour.getContent());
        routine.setText(commentTour.getRoutine());
        location.setText(commentTour.getLocation());
        time.setText(commentTour.getTime());
        price.setText(commentTour.getPrice());
        vehicle.setText(commentTour.getVehicle());
        place.setText(commentTour.getPlace());
        comment.setText(commentTour.getComment());

//        int drawablResId = getResources().getIdentifier(commentTour.getPic(), "drawable", getPackageName());

    }
    private void initView() {
        pic = findViewById(R.id.img);
        content = findViewById(R.id.content);
        routine = findViewById(R.id.routine);
        location = findViewById(R.id.location);
        time = findViewById(R.id.time);
        price = findViewById(R.id.price);
        vehicle = findViewById(R.id.vehivle);
        place = findViewById(R.id.place);
        comment = findViewById(R.id.comment);
    }

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