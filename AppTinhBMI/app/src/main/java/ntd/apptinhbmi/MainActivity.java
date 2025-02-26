package ntd.apptinhbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Khai báo các điều khiển giao diện
    EditText editTextWeight;
    EditText editTextHeight;
    EditText editTextKetQua;
    Button nutTinh;

    public void TimDieuKhien() {
        editTextWeight = findViewById(R.id.edtWeight);
        editTextHeight = findViewById(R.id.edtHeight);
        editTextKetQua = findViewById(R.id.edtKetQua);
        nutTinh = findViewById(R.id.btnCalculate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

        // Gán sự kiện cho nút tính toán
        nutTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhToan();
            }
        });
    }

    public void TinhToan() {
        // Lấy dữ liệu từ 2 ô nhập
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cân nặng và chiều cao!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float weight = Float.parseFloat(weightString);
            float height = Float.parseFloat(heightString) / 100; // Chuyển cm sang m
            
            if (height <= 0) {
                Toast.makeText(this, "Chiều cao phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tính BMI
            float bmi = weight / (height * height);

            // Hiển thị kết quả
            editTextKetQua.setText(String.format("BMI: %.2f", bmi));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
