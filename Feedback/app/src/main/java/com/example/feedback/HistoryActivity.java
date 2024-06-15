package com.example.feedback;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feedback.Adapter.TourAdapter;
import com.example.feedback.Model.Tour;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rcv_tour;
    List<Tour> tours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        rcv_tour = findViewById(R.id.rcv_tour);
        rcv_tour.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        tours = new ArrayList<>();

        tours.add(new Tour(R.drawable.halong, "Tham quan vịnh hạ long", "Hà Nội - Phú Quốc", "-\tHạ Long là thành phố tỉnh lỵ của tỉnh Quảng Ninh, Việt Nam. \n-\tThành phố được đặt theo tên của vịnh Hạ Long, vịnh biển nằm ở phía nam thành phố và là một di sản thiên nhiên nổi tiếng của Việt Nam. \n-\tTên Hạ Long nghĩa là con rồng bay xuống"
                ,"\t\t2 ngày 1 đêm","\t\t2.500.000 VND", "\t\tÔ tô","\t\tKhách sạn Mường Thanh",null));
        tours.add(new Tour(R.drawable.sapa, "Đỉnh núi Fan xi Păng", "Hà Nội - Lào Cai", "Được biết đến là ngọn núi cao nhất Việt Nam cũng như ba nước Đông Dương, ngọn núi Fansipan có độ cao 3.143m so với mặt nước biển và nằm giữa trung tâm dãy Hoàng Liên Sơn, giáp với tỉnh Lai Châu.","2N1Đ","2 triệu", "oto","2 triệu","Rất tốt"));
        tours.add(new Tour(R.drawable.dalat, "Vườn hoa Đà Lạt", "Hà Nội - Lâm Đồng", "Đà Lạt là thành phố tỉnh lỵ trực thuộc tỉnh Lâm Đồng, nằm trên cao nguyên Lâm Viên, thuộc vùng Tây Nguyên, Việt Nam. ","2N1Đ","2 triệu", "oto","2 triệu","Rất tốt"));
        tours.add(new Tour(R.drawable.danang, "Cầu vàng", "Hà Nội - Đà Nẵng", "Siêu dàiĐà Nẵng là một trong năm thành phố trực thuộc trung ương của Việt Nam, nằm tại vùng Duyên hải Nam Trung Bộ. Đây là thành phố trung tâm và lớn nhất của toàn bộ khu vực Miền Trung, đóng vai trò là hạt nhân quan trọng của Vùng kinh tế trọng điểm Miền Trung.","2N1Đ","2 triệu", "oto","2 triệu","Rất tốt"));

        TourAdapter adapter =new TourAdapter(tours, this);
        rcv_tour.setAdapter(adapter);


    }
}