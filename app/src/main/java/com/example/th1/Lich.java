package com.example.th1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

public class Lich extends Activity {

    private EditText edtNamDuong;
    private Button btnChuyenDoi, btnExit;
    private TextView txtNamAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lich);

        edtNamDuong = findViewById(R.id.edtNamDuong);
        btnExit = findViewById(R.id.btnExit);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);
        txtNamAm = findViewById(R.id.txtNamAm);

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namDuongStr = edtNamDuong.getText().toString();
                try {
                    int namDuong = Integer.parseInt(namDuongStr);
                    if (namDuong >= 1900) {
                        String can = getCan(namDuong);
                        String chi = getChi(namDuong);
                        String namAm = can + " " + chi;
                        txtNamAm.setText(namAm);
                    } else {
                        txtNamAm.setText("Năm dương lịch phải lớn hơn hoặc bằng 1900");
                    }
                } catch (NumberFormatException e) {
                    txtNamAm.setText("Vui lòng nhập số");
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Lich.this);
                builder.setTitle("Question?");
                builder.setMessage("Are you sure you want to exit?");
                builder.setPositiveButton("Yes", (dialog, which) -> finish());
                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        });
    }

    private String getCan(int namDuong) {
        String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        return can[namDuong % 10];
    }

    private String getChi(int namDuong) {
        String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};
        return chi[namDuong % 12];
    }
}
