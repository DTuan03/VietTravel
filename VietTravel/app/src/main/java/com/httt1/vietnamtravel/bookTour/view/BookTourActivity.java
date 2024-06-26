package com.httt1.vietnamtravel.bookTour.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.httt1.vietnamtravel.R;
import com.httt1.vietnamtravel.bookTour.presenter.BookTourContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookTourActivity extends AppCompatActivity implements BookTourContract.View {
    private EditText etName, etPhone, etMail, etNumberBook, startDay, endDay;
    private Spinner paymentMethod, voucher;
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        // Dữ liệu cho Spinner
        String[] vouchers = {"Voucher 1", "Voucher 2", "Voucher 3", "Voucher 4"};

        // Tạo ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vouchers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gán Adapter cho Spinner
        voucher.setAdapter(adapter);

        voucher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedItem = null; // Hoặc giá trị mặc định khác nếu cần
            }
        });

        paymentMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedItem = null; // Hoặc giá trị mặc định khác nếu cần
            }
        });
    }

    private void init(){
        etName = findViewById(R.id.activity_book_tour_et_username);
        etPhone = findViewById(R.id.activity_book_tour_et_phonenumber);
        etMail = findViewById(R.id.activity_book_tour_et_email);
        etNumberBook = findViewById(R.id.activity_book_tour_et_number_people);
        startDay = findViewById(R.id.activity_book_tour_et_start_day);
        endDay = findViewById(R.id.activity_book_tour_et_end_day);
        paymentMethod = findViewById(R.id.activity_book_tour_sp_payment_method);
        voucher = findViewById(R.id.activity_book_tour_sp_voucher);
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString();
    }

    @Override
    public String getEmail() {
        return etMail.getText().toString();
    }

    @Override
    public Date getStarDay() {
        String dateStr = startDay.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Date getEndDay() {
        String dateStr = endDay.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getNumberBook() {
        return Integer.parseInt(etNumberBook.getText().toString());
    }

    @Override
    public String getVoucher() {
        return selectedItem;
    }

    @Override
    public String getPayMendMethod() {
        return selectedItem;
    }
}