package ntd.chuyenmanhinhquiz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class ActivityHome extends AppCompatActivity {
    Button btnQuayLai;
    ImageView imageView;
    TextView tvUserName;

    public void TimDieuKhien(){
        tvUserName = findViewById(R.id.tvUserName);
        btnQuayLai = findViewById(R.id.btnQuaylai);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TimDieuKhien();
        loadAnhTuAssets("anhdep.png");

        // Kiểm tra và lấy dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("UserName")) {
            String strUserName = intent.getStringExtra("UserName");
            tvUserName.setText(strUserName);
        } else {
            tvUserName.setText("Không xác định");
        }

        // Xử lý sự kiện quay lại
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iQuayLai = new Intent(ActivityHome.this, MainActivity.class);
                startActivity(iQuayLai);
            }
        });
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
