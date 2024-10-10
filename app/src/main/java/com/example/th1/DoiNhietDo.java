package com.example.th1;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;

public class DoiNhietDo extends Activity {

    private EditText editTextFahrenheit, editTextCelsius;
    private Button buttonToCelsius, buttonToFahrenheit, buttonClear, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nhietdo);

        // Initialize the views
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonToCelsius = findViewById(R.id.buttonToCelsius);
        buttonToFahrenheit = findViewById(R.id.buttonToFahrenheit);
        buttonClear = findViewById(R.id.buttonClear);
        Button exitButton = findViewById(R.id.btnExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng ứng dụng
                showExitConfirmationDialog();
            }
        });
        // Convert Fahrenheit to Celsius
        buttonToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextFahrenheit.getText().toString().isEmpty()) {
                    double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    editTextCelsius.setText(String.format("%.2f", celsius));
                } else {
                    Toast.makeText(DoiNhietDo.this, "Vui lòng nhập giá trị Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Convert Celsius to Fahrenheit
        buttonToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextCelsius.getText().toString().isEmpty()) {
                    double celsius = Double.parseDouble(editTextCelsius.getText().toString());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    editTextFahrenheit.setText(String.format("%.2f", fahrenheit));
                } else {
                    Toast.makeText(DoiNhietDo.this, "Vui lòng nhập giá trị Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Clear all fields
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFahrenheit.setText("");
                editTextCelsius.setText("");
            }
        });
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

}

