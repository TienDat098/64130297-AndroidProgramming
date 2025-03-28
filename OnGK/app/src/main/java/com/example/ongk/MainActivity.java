package com.example.ongk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    CardView cardView1,cardView2,cardView3,cardView4;

    public void TiemDieuKhien(){
        cardView1 = findViewById(R.id.card1);
        cardView2 = findViewById(R.id.card2);
        cardView3 = findViewById(R.id.card3);
        cardView4 = findViewById(R.id.card4);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    TiemDieuKhien();
       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent2=new Intent(MainActivity.this,ActivityCau2.class);
               startActivity(intent2);
           }
       });
       btn4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent4=new Intent(MainActivity.this,MyProfileActivity.class);
               startActivity(intent4);

           }
       });
    }
}