package ntd.apptinhcv_dt_circle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    EditText edtBanKinh, edtChuVi, edtDienTich;
    Button calculateButton, resetButton;
    ImageView imgCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần trong giao diện
        edtBanKinh = findViewById(R.id.edtBanKinh);
        edtChuVi = findViewById(R.id.edtChuVi);
        edtDienTich = findViewById(R.id.edtDienTich);
        calculateButton = findViewById(R.id.calculateButton);
        resetButton = findViewById(R.id.resetButton);
        imgCircle = findViewById(R.id.imgCircle);


        // Xử lý sự kiện khi bấm nút tính toán
        calculateButton.setOnClickListener(view -> tinhToan());

        // Xử lý sự kiện khi bấm nút xóa
        resetButton.setOnClickListener(view -> xoaDuLieu());
        loadAnhTuAssets("anh_hinhtron.png");

    }

    private void tinhToan() {
        String banKinhText = edtBanKinh.getText().toString();

        if (banKinhText.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập bán kính!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double banKinh = Double.parseDouble(banKinhText);
            double chuVi = 2 * Math.PI * banKinh; // Chu vi
            double dienTich = Math.PI * banKinh * banKinh; // Diện tích

            edtChuVi.setText(String.format("%.2f cm", chuVi));
            edtDienTich.setText(String.format("%.2f cm²", dienTich));
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi! Vui lòng nhập số hợp lệ.", Toast.LENGTH_SHORT).show();
        }
    }

    private void xoaDuLieu() {
        edtBanKinh.setText("");
        edtChuVi.setText("");
        edtDienTich.setText("");
    }
    public void loadAnhTuAssets(String tenFileAnh) {
        try {
            InputStream inputStream = getAssets().open(tenFileAnh);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imgCircle.setImageBitmap(bitmap);
            imgCircle.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            imgCircle.setVisibility(View.GONE);
            Toast.makeText(this, "Không tìm thấy ảnh!", Toast.LENGTH_SHORT).show();
        }
    }

}