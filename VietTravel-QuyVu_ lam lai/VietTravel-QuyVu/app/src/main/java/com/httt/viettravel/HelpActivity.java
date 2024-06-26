package com.httt.viettravel;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_help);
        initUI();
    }

    private void initUI() {
        // Lấy các thành phần từ layout
        CardView question1 = findViewById(R.id.question1);
        CardView question2 = findViewById(R.id.question2);
        CardView question3 = findViewById(R.id.question3);
        CardView question4 = findViewById(R.id.question4);
        CardView question5 = findViewById(R.id.question5);

        ImageView arrow_down1 = findViewById(R.id.arrow_down1);
        ImageView arrow_down2 = findViewById(R.id.arrow_down2);
        ImageView arrow_down3 = findViewById(R.id.arrow_down3);
        ImageView arrow_down4 = findViewById(R.id.arrow_down4);
        ImageView arrow_down5 = findViewById(R.id.arrow_down5);



        TextView answer1 = findViewById(R.id.answer1);
        TextView answer2 = findViewById(R.id.answer2);
        TextView answer3 = findViewById(R.id.answer3);
        TextView answer4 = findViewById(R.id.answer4);
        TextView answer5 = findViewById(R.id.answer5);

        // Đặt sự kiện onClick cho từng câu hỏi để hiển thị hoặc ẩn câu trả lời
        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getVisibility() == View.GONE) {
                    answer1.setVisibility(View.VISIBLE);
                    arrow_down1.setImageResource(R.mipmap.arrow_up); // Đảm bảo rằng bạn có icon này trong mipmap
                } else {
                    answer1.setVisibility(View.GONE);
                    arrow_down1.setImageResource(R.mipmap.arrow_down); // Đảm bảo rằng bạn có icon này trong mipmap
                }
            }
        });
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getVisibility() == View.GONE) {
                    answer2.setVisibility(View.VISIBLE);
                    arrow_down2.setImageResource(R.mipmap.arrow_up); // Đảm bảo rằng bạn có icon này trong mipmap
                } else {
                    answer2.setVisibility(View.GONE);
                    arrow_down2.setImageResource(R.mipmap.arrow_down); // Đảm bảo rằng bạn có icon này trong mipmap
                }
            }
        });

        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getVisibility() == View.GONE) {
                    answer3.setVisibility(View.VISIBLE);
                    arrow_down3.setImageResource(R.mipmap.arrow_up); // Đảm bảo rằng bạn có icon này trong mipmap
                } else {
                    answer3.setVisibility(View.GONE);
                    arrow_down3.setImageResource(R.mipmap.arrow_down); // Đảm bảo rằng bạn có icon này trong mipmap
                }
            }
        });
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getVisibility() == View.GONE) {
                    answer4.setVisibility(View.VISIBLE);
                    arrow_down4.setImageResource(R.mipmap.arrow_up); // Đảm bảo rằng bạn có icon này trong mipmap
                } else {
                    answer4.setVisibility(View.GONE);
                    arrow_down4.setImageResource(R.mipmap.arrow_down); // Đảm bảo rằng bạn có icon này trong mipmap
                }
            }
        });

        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer5.getVisibility() == View.GONE) {
                    answer5.setVisibility(View.VISIBLE);
                    arrow_down5.setImageResource(R.mipmap.arrow_up); // Đảm bảo rằng bạn có icon này trong mipmap
                } else {
                    answer5.setVisibility(View.GONE);
                    arrow_down5.setImageResource(R.mipmap.arrow_down); // Đảm bảo rằng bạn có icon này trong mipmap
                }
            }
        });
    }
}