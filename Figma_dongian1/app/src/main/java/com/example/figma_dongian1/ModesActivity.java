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
    CardView Row1Card1,Row1Card2,Row2Card1,Row2Card2;

public void TimDieuKhien(){

    Row1Card1=findViewById(R.id.Row1_card1);
    Row1Card2=findViewById(R.id.Row1_card2);
    Row2Card1=findViewById(R.id.Row2_card1);
    Row2Card2=findViewById(R.id.Row2_card2);

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
    Row1Card2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2=new Intent(ModesActivity.this,MatchActivity.class);
            startActivity(intent2);
        }
    });

    Row2Card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(ModesActivity.this,MainActivity.class);
                startActivity(intent4);
            }
        });


    }
}