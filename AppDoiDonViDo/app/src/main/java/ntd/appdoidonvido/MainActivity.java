package ntd.appdoidonvido;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput;
    private Spinner spinnerFrom, spinnerTo;
    private TextView tvResult;
    private Button btnConvert;
    ImageView imgAnh1;

    private final String[] units = {"Lít (L)", "Mililit (mL)", "Mét khối (m³)", "Centimet khối (cm³)"};
    private final HashMap<String, Double> unitValues = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edtInput);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        tvResult = findViewById(R.id.tvResult);
        btnConvert = findViewById(R.id.btnConvert);
        imgAnh1 = findViewById(R.id.imgAnh1); // Ánh xạ ImageView


        // Khởi tạo danh sách đơn vị và giá trị chuẩn theo Lít
        unitValues.put("Lít (L)", 1.0);
        unitValues.put("Mililit (mL)", 1000.0);
        unitValues.put("Mét khối (m³)", 0.001);
        unitValues.put("Centimet khối (cm³)", 1000.0);

        // Gán adapter cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        // Xử lý sự kiện chuyển đổi
        btnConvert.setOnClickListener(view -> convertVolume());
        loadAnhTuAssets("donvido.png");
    }

    private void convertVolume() {
        String inputText = edtInput.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập giá trị!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double inputValue = Double.parseDouble(inputText);
            String fromUnit = spinnerFrom.getSelectedItem().toString();
            String toUnit = spinnerTo.getSelectedItem().toString();

            // Đổi về đơn vị chuẩn (Lít), sau đó đổi sang đơn vị đích
            double result = inputValue * (unitValues.get(toUnit) / unitValues.get(fromUnit));

            tvResult.setText(String.format("Kết quả: %.2f %s", result, toUnit));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Lỗi! Vui lòng nhập số hợp lệ.", Toast.LENGTH_SHORT).show();
        }
    }
    public void loadAnhTuAssets(String tenFileAnh) {
        try {
            InputStream inputStream = getAssets().open(tenFileAnh);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imgAnh1.setImageBitmap(bitmap);
            imgAnh1.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            imgAnh1.setVisibility(View.GONE);
            Toast.makeText(this, "Không tìm thấy ảnh!", Toast.LENGTH_SHORT).show();
        }
    }
}
