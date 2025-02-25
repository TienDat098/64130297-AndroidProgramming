package com.example.apptinhtoan;

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
        // Gọi hàm load ảnh từ assets vào ImageView
        loadAnhTuAssets("anh_tinhtoan.png");
    }

    //Xử lý cộng
    public void XuLyCong(View v){
        //code xử lý cộng ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1 Tìm EditText số 1 và số 2

        //b1.2 Lâ dữ liệu từ 2 đkhiển đó
        String soThu1 =  editTextSo1.getText().toString();
        String soThu2 =  editTextSo2.getText().toString();
        //b1.3 Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2.Tính Toán
        float Tong =soA +soB;
        //Bước 3 Hiện kết quả
        //Bước 3.1
        EditText editTextKQ = findViewById(R.id.edtKetQua);
        //bUOC 3,2 chuẩn bị d liệu xuât,biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tong);
        //Bước 3.3. Gắn kêt quả lên iều khiển
        editTextKQ.setText(chuoiKQ);

    }
    //Xử lý trừ
    public void XuLyTru(View v){
        //b1. Lấy dữ liệu 2 số
        //b1.1 Tìm EditText số 1 và số 2
        //b1.2 Lâ dữ liệu từ 2 đkhiển đó
        String soThu1 =  editTextSo1.getText().toString();
        String soThu2 =  editTextSo2.getText().toString();
        //b1.3 Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2.Tính Toán
        float Hieu =soA - soB;
        //Bước 3 Hiện kết quả
        //Bước 3.1

        //bUOC 3,2 chuẩn bị d liệu xuât,biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Hieu);
        //Bước 3.3. Gắn kêt quả lên iều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý nhân
    public void XuLyNhan(View v){
        //b1. Lấy dữ liệu 2 số
        //b1.1 Tìm EditText số 1 và số 2

        //b1.2 Lâ dữ liệu từ 2 đkhiển đó
        String soThu1 =  editTextSo1.getText().toString();
        String soThu2 =  editTextSo2.getText().toString();
        //b1.3 Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2.Tính Toán
        float Tich =soA * soB;
        //Bước 3 Hiện kết quả
        //Bước 3.1
        //bUOC 3,2 chuẩn bị d liệu xuât,biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tich);
        //Bước 3.3. Gắn kêt quả lên iều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý chia
    public void XuLyChia(View v){
        //b1. Lấy dữ liệu 2 số
        //b1.1 Tìm EditText số 1 và số 2
        //b1.2 Lâ dữ liệu từ 2 đkhiển đó
        String soThu1 =  editTextSo1.getText().toString();
        String soThu2 =  editTextSo2.getText().toString();
        //b1.3 Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2.Tính Toán
        float Thuong =soA / soB;
        //Bước 3 Hiện kết quả
        //Bước 3.1

        //bUOC 3,2 chuẩn bị d liệu xuât,biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Thuong);
        //Bước 3.3. Gắn kêt quả lên iều khiển
        editTextKQ.setText(chuoiKQ);
    }
    public void loadAnhTuAssets(String tenFileAnh) {
        try {
            InputStream inputStream = getAssets().open(tenFileAnh);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}