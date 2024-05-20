package com.httt.viettravel;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ContactActivity extends ListActivity {
    private static final String[] items = {"lorem", "ipsum", "dolor",
            "sit", "amet", "consectetuer",
            "adipiscing", "elit", "morbi",
            "vel", "ligua", "vitae",
            "arcu", "aliquet", "mollis",
            "eiam", "vel", "erat",
            "placerat", "ante", "porttitor",
            "sodales", "pellentesque", "augue",
            "purus"};
    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(ContactActivity.this, android.R.layout.simple_list_item_1, items);
        setListAdapter(myArrayAdapter);
    }
}
