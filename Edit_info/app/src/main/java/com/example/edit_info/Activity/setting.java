package com.example.edit_info.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.edit_info.R;
import com.google.android.material.textfield.TextInputEditText;

public class setting extends AppCompatActivity {
    private TextInputEditText edtFullName, edtEmail, edtAddress, edtPhone;
    private String fullName, email, address, phone;
    Button btnCapnhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtDiachi);
        edtPhone = findViewById(R.id.edtSodienthoai);
        btnCapnhat = findViewById(R.id.btnCapnhat);

        // Khởi tạo giá trị ban đầu cho các biến
        fullName = edtFullName.getText().toString();
        email = edtEmail.getText().toString();
        address = edtAddress.getText().toString();
        phone = edtPhone.getText().toString();

        edtFullName.setText("Vũ Quý");
        edtEmail.setText("quyvu@example.com");
        edtAddress.setText("Quảng Ninh");
        edtPhone.setText("5551234");
        setupTextChangedListeners();

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValues();
            }
        });
    }

    private void updateValues() {
        fullName = edtFullName.getText().toString();
        email = edtEmail.getText().toString();
        address = edtAddress.getText().toString();
        phone = edtPhone.getText().toString();

        // Cập nhật các giá trị
        edtFullName.setText(fullName);
        edtEmail.setText(email);
        edtAddress.setText(address);
        edtPhone.setText(phone);

        // Hiển thị thông báo
        Toast.makeText(this, "Dữ liệu đã được cập nhật", Toast.LENGTH_SHORT).show();
    }

    private void setupTextChangedListeners() {
        edtFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                fullName = s.toString();
            }
        });

       edtEmail.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
               email = s.toString();
           }
       });

       edtAddress.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
               address = s.toString();
           }
       });
       edtPhone.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
               phone = s.toString();
           }
       });
    }
}