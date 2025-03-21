package com.example.figma_dongian1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModesActivity extends AppCompatActivity {
    CardView Row1Card1;

public void TimDieuKhien(){

    Row1Card1=findViewById(R.id.Row1_card1);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes);
    TimDieuKhien();

    Row1Card1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1=new Intent(ModesActivity.this,CountActivity.class);
            startActivity(intent1);
        }
    });



    }
}