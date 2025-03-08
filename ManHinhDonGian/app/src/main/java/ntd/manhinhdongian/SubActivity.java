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

public class SubActivity extends AppCompatActivity {
    Button btnQuayLai;
    void TimDieuKhien(){
        btnQuayLai =findViewById(R.id.btnQuayLai);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        TimDieuKhien();
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenTrangChu= new Intent(SubActivity.this,MainActivity.class);
                startActivity(chuyenTrangChu);
            }
        });

    }
}