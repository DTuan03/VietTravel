package com.httt.viettravel;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String[] items = {"lorem", "ipsum", "dolor",
            "sit", "amet", "consectetuer",
            "adipiscing", "elit", "morbi",
            "vel", "ligua", "vitae",
            "arcu", "aliquet", "mollis",
            "eiam", "vel", "erat",
            "placerat", "ante", "porttitor",
            "sodales", "pellentesque", "augue",
            "purus"};

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
        ListView myListView = (ListView) findViewById(R.id.myListView);

        //Khai bao MyArrayAdapter
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);

        //Gan  ArrAdapter vao cho ListView
        myListView.setAdapter(myArrayAdapter);
    }
}