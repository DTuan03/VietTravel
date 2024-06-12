package com.httt.viettravel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccountActivity extends AppCompatActivity {

    private TextView tvEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        showDialog();
    }

    private void init(){
        tvEditName = (TextView) findViewById(R.id.activity_account_tv_edit_name);
    }

    private void showDialog(){
        tvEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountNameDialogFragment accountNameDialogFragment = new AccountNameDialogFragment();
//                Lưu ý bên Fragment tương ứng phải sửa thành kế thừa DialogFragment (tương tự Fragment) kh thi se bao loi
                accountNameDialogFragment.show(getSupportFragmentManager(), "AccountNameDialogFragment");
            }
        });
    }
}