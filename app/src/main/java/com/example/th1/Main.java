package com.example.th1;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class Main extends Activity implements View.OnClickListener {
    //public class Main extends Activity {
    private EditText edita, editb;
    private TextView simpleTextView;
    // Listener không thay đổi để tính thương 2 số
    private final View.OnClickListener divisionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                String strA = edita.getText().toString();
                String strB = editb.getText().toString();

                if (strA.isEmpty() || strB.isEmpty()) {
                    simpleTextView.setText("Vui lòng nhập đủ hai số!");
                    return;
                }

                int a = Integer.parseInt(strA);
                int b = Integer.parseInt(strB);

                if (b == 0) {
                    simpleTextView.setText("Không thể chia cho 0!");
                } else {
                    int thuong = a / b;
                    simpleTextView.setText("Thương 2 số là: " + thuong);
                    Toast.makeText(getApplication(), "Thương hai số là: " + thuong, Toast.LENGTH_LONG).show();
                }
            } catch (NumberFormatException e) {
                simpleTextView.setText("Vui lòng nhập số hợp lệ!");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_exit);
        edita = findViewById(R.id.edtSoA);
        editb = findViewById(R.id.edtSoB);
        Button hieu = findViewById(R.id.btnHieu);
        Button tich = findViewById(R.id.btnTich);
        Button thuong = findViewById(R.id.btnThuong);
        Button gcdButton = findViewById(R.id.btnGcd);
        simpleTextView = findViewById(R.id.simpleTextView);
        Button exitButton = findViewById(R.id.btnExit);
        tich.setOnClickListener(this);
        thuong.setOnClickListener(divisionListener);
        gcdButton.setOnClickListener(new GcdButtonListener());
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng ứng dụng
                showExitConfirmationDialog();
            }
        });
        // Thiết lập sự kiện cho nút hiệu (Inline Anonymous Listener)
        hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String strA = edita.getText().toString();
                    String strB = editb.getText().toString();

                    if (strA.isEmpty() || strB.isEmpty()) {
                        simpleTextView.setText("Vui lòng nhập đủ hai số!");
                        return;
                    }

                    int a = Integer.parseInt(strA);
                    int b = Integer.parseInt(strB);
                    int hieu = a - b;
                    simpleTextView.setText("Hiệu 2 số là: " + hieu);
                    Toast.makeText(getApplication(), "Hiệu hai số là: " + hieu, Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e) {
                    simpleTextView.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    // Phương thức xử lý sự kiện OnClick
    @Override
    public void onClick(View view) {
        String strA = edita.getText().toString();
        String strB = editb.getText().toString();
        if (strA.isEmpty() || strB.isEmpty()) {
            simpleTextView.setText("Vui lòng nhập đủ hai số!");
            return;
        }
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        if (view.getId() == R.id.btnTich) {
            int tich = a * b;
            simpleTextView.setText("Tích 2 số là: " + tich);
            Toast.makeText(getApplication(), "Tích hai số là: " + tich, Toast.LENGTH_LONG).show();
        }
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận thoát!!!!!!!!!!");
        builder.setMessage("Bạn có muốn thoát chương trình không?");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Đóng ứng dụng
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(), "Bạn chọn không thoát", Toast.LENGTH_LONG).show();
                dialog.dismiss(); // Đóng hộp thoại và ở lại trang hiện tại
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void calculateSum(View view) {
        try {
            // Get input from EditText and calculate the sum
            int a = Integer.parseInt(edita.getText().toString());
            int b = Integer.parseInt(editb.getText().toString());
            int tong = a + b;

            // Set the result to the TextView
            simpleTextView.setText("Tổng 2 số là: " + tong);
            Toast.makeText(getApplication(), "Tổng hai số là: " + tong, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            // Handle error if the input is not a number
            simpleTextView.setText("Vui lòng nhập số hợp lệ!");
        }
    }

    // Lớp con riêng biệt cho sự kiện tính GCD (Explicit Listener Class)
    private class GcdButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
                String strA = edita.getText().toString();
                String strB = editb.getText().toString();

                if (strA.isEmpty() || strB.isEmpty()) {
                    simpleTextView.setText("Vui lòng nhập đủ hai số!");
                    return;
                }

                int a = Integer.parseInt(strA);
                int b = Integer.parseInt(strB);

                // Tính GCD bằng thuật toán Euclid
                int gcd = calculateGCD(a, b);
                simpleTextView.setText("Ước số chung lớn nhất là: " + gcd);
                Toast.makeText(getApplication(), "Ước chung lớn nhất hai số là: " + gcd, Toast.LENGTH_LONG).show();

            } catch (NumberFormatException e) {
                simpleTextView.setText("Vui lòng nhập số hợp lệ!");
            }
        }

        // Hàm tính GCD bằng thuật toán Euclid
        private int calculateGCD(int a, int b) {
            if (b == 0) {
                return a;
            }
            return calculateGCD(b, a % b);
        }
    }
}