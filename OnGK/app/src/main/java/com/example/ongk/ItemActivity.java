package com.example.ongk;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemActivity extends AppCompatActivity {
    TextView tvSportName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item);
        tvSportName = findViewById(R.id.tvSportName);
        // Nhận dữ liệu từ Intent
        String sportName = getIntent().getStringExtra("sport_name");
        tvSportName.setText(sportName);

    }
}