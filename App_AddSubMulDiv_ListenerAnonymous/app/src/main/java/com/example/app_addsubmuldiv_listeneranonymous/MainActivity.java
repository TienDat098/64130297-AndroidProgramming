package com.example.app_addsubmuldiv_listeneranonymous;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai báo các đối tượng gắn với đkhiển tương ứng ở đây
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    ImageView imageView;
    Button nutCong,nutTru,nutNhan,nutChia;
    public void TimDieuKhien(){
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKQ = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
        imageView = findViewById(R.id.myImageView);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //Gắn bộ lắng nghe sự kiện và code xử lý cho từng nút
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_CONG();
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_TRU();
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_NHAN();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_CHIA();
            }
        });
        // Gọi hàm load ảnh từ assets vào ImageView
        loadAnhTuAssets("anhmaytinh1.png");
    }

    //Xử lý cộng
     void XULY_CONG(){

        String so1 =  editTextSo1.getText().toString();
        String so2 =  editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong =num1 +num2;
        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);

    }
    //Xử lý trừ
     void XULY_TRU(){
        String so1 =  editTextSo1.getText().toString();
        String so2 =  editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong =num1  - num2;
        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý nhân
     void XULY_NHAN(){
        String so1 =  editTextSo1.getText().toString();
        String so2 =  editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong =num1  * num2;
        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý chia
     void XULY_CHIA(){
        String so1 =  editTextSo1.getText().toString();
        String so2 =  editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong =num1  / num2;
        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);
    }
     void loadAnhTuAssets(String tenFileAnh) {
        try {
            InputStream inputStream = getAssets().open(tenFileAnh);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}