package com.httt.viettravel;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Adapter.TermAdapter;
import com.httt.viettravel.Model.Term;

import java.util.ArrayList;

public class TermActivity extends AppCompatActivity {

    ArrayList<Term> listTerms;
    RecyclerView recyclerView;
    TermAdapter termAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_term);

        recyclerView = findViewById(R.id.rcv_term);


        listTerms = new ArrayList<>();

        listTerms.add(new Term("Chính sách1", "Chi tiết tại đây11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",true));
        listTerms.add(new Term("Chính sách2", "Chi tiết tại đây2",false));
        listTerms.add(new Term("Chính sách1", "Chi tiết tại đây11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",true));
        listTerms.add(new Term("Chính sách1", "Chi tiết tại đây11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",true));
        listTerms.add(new Term("Chính sách1", "Chi tiết tại đây11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",true));
        listTerms.add(new Term("Chính sách1", "Chi tiết tại đây11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",true));
        listTerms.add(new Term("Chính sách1", "Chi tiết tại đây11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",true));

        termAdapter = new TermAdapter(listTerms, TermActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(termAdapter);
//        recyclerView.set


    }
}