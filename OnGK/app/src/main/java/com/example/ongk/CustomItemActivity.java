package com.example.ongk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CustomItemActivity extends AppCompatActivity {
    TextView tvName;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_item);

        tvName = findViewById(R.id.tvCustom);
        imageView = findViewById(R.id.ivImage);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("course_name");
            String imageName = intent.getStringExtra("course_image"); // Lấy tên ảnh từ Intent

            // Hiển thị tên khoá học
            tvName.setText(name);

            // Lấy ID của ảnh trong mipmap
            int imageResId = getResources().getIdentifier(imageName, "mipmap", getPackageName());

            // Nếu không tìm thấy ảnh, đặt ảnh mặc định
            if (imageResId == 0) {
                imageResId = R.drawable.anhdep; // Ảnh mặc định
            }

            // Hiển thị ảnh trong ImageView
            imageView.setImageResource(imageResId);
        }
    }
}
