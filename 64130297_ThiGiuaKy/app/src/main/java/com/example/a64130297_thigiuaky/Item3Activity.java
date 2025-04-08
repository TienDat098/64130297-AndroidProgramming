package com.example.a64130297_thigiuaky;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Item3Activity extends AppCompatActivity {
    TextView tvBaiHatName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item3);
        tvBaiHatName=findViewById(R.id.tvBHName);

        String sportName = getIntent().getStringExtra("Baihat_name");
        tvBaiHatName.setText(sportName);



    }
}