package com.example.ongk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityCau2 extends AppCompatActivity {
    ListView listViewsports;
    ArrayList<String> dsSports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);


        listViewsports=findViewById(R.id.LVsports);
        dsSports=new ArrayList<String>();
        dsSports.add("Cầu lông");
        dsSports.add("Bóng chuyền");
        dsSports.add("Bóng đá");
        dsSports.add("Bóng rổ");
        dsSports.add("Bơi lội");
        dsSports.add("pickleball ball");
        dsSports.add("Tennis");
        dsSports.add("Leo núi");
        dsSports.add("Tập võ");

        ArrayAdapter<String> adapterSports;
        adapterSports=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,dsSports);
        listViewsports.setAdapter(adapterSports);

        listViewsports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String giaTriDuocChon=dsSports.get(position);
                // Chuyển qua ItemActivity và gửi dữ liệu
                Intent intent = new Intent(ActivityCau2.this, ItemActivity.class);
                intent.putExtra("sport_name", giaTriDuocChon);
                startActivity(intent);
            }
        });


    }
}