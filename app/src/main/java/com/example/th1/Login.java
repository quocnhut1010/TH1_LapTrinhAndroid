package com.example.th1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    private EditText edtUsername, edtPassword;
    private CheckBox chkRemember;
    private Button btnLogin, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkRemember = findViewById(R.id.chkRemember);
        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String message;
                if (chkRemember.isChecked()) {
                    message = "Chào mừng " + username + " đăng nhập hệ thống, bạn đã lưu thông tin";
                } else {
                    message = "Chào mừng " + username + " đăng nhập hệ thống, bạn không lưu thông tin";
                }
                // Display the message with the username in a Toast
                Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setTitle("Question?");
                builder.setMessage("Are you sure you want to exit?");
                builder.setPositiveButton("Yes", (dialog, which) -> finish());
                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        });
    }
}
