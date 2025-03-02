package ntd.apptinhbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.edtWeight);
        editTextHeight = findViewById(R.id.edtHeight);
        textViewResult = findViewById(R.id.edtKetQua);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cân nặng và chiều cao!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100;

            if (height <= 0 || weight <= 0) {
                Toast.makeText(this, "Giá trị nhập vào không hợp lệ!", Toast.LENGTH_SHORT).show();
                return;
            }

            float bmi = weight / (height * height);
            String category = classifyBMI(bmi);
            textViewResult.setText(String.format("BMI: %.2f\nPhân loại: %s", bmi, category));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }

    private String classifyBMI(float bmi) {
        if (bmi < 18.5) return "Cân nặng thấp (Gầy)";
        else if (bmi < 23) return "Bình thường (IDI & WPRO)";
        else if (bmi < 25) return "Thừa cân (IDI & WPRO)";
        else if (bmi < 30) return "Tiền béo phì";
        else if (bmi < 35) return "Béo phì độ I";
        else if (bmi < 40) return "Béo phì độ II";
        else return "Béo phì độ III";
    }
}
