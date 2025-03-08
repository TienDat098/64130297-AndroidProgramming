package ntd.manhinhdongian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnChuyen;
    void TimDieuKhien(){
        btnChuyen=findViewById(R.id.btnChuyen);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //gắn bộ lắng nghe sự kiện
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý màn hình
                //b1.tạo một Intent 2 tham số: 1 màn hình hiện tại.this;  2)màn hình chuyển tới.class
                Intent  intentMH2 = new Intent(MainActivity.this,SubActivity.class);
                //Bước 2 gửi
                startActivity(intentMH2);
            }
        });

    }
}