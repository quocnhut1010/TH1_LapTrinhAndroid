package com.example.th1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivitySecond extends Activity {
    ImageView selectedImage;
    TextView imageName;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        selectedImage = findViewById(R.id.selectedImage); // Khởi tạo ImageView
        imageName = findViewById(R.id.imageName); // Khởi tạo TextView để hiển thị tên ảnh
        backButton = findViewById(R.id.backButton); // Khởi tạo nút quay lại

        // Lấy intent từ activity trước
        Intent intent = getIntent();

        // Khai báo và gán giá trị cho imageRes
        int imageRes = intent.getIntExtra("image", 0); // get image resource ID
        if (imageRes != 0) {
            selectedImage.setImageResource(imageRes); // Gán ảnh vào ImageView

            // Hiển thị tên của hình ảnh từ drawable
            String imageNameStr = getResources().getResourceEntryName(imageRes); // get image name
            imageName.setText("Cờ của nước: " + imageNameStr);
        }

        // Xử lý sự kiện nhấn nút "Quay lại"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // kết thúc ActivitySecond và quay lại Activity trước
            }
        });
    }
}
