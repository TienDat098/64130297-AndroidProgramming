package com.example.a64130297_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Activity_Chucnang3 extends AppCompatActivity {
    ListView listViewsBaihat;
    ArrayList<String> dsSBaihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chucnang3);
        listViewsBaihat=findViewById(R.id.LVBaiHat);

        dsSBaihat=new ArrayList<String>();
        dsSBaihat.add("Tiến về Sài Gòn");
        dsSBaihat.add("Giaỉ phóng Miền Nam");
        dsSBaihat.add("Đất nước trọn niềm vui");
        dsSBaihat.add("Bài ca thống nhất");
        dsSBaihat.add("Mùa xuân trên thành phố HCM");



        ArrayAdapter<String> adapterSports;
        adapterSports=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,dsSBaihat);
        listViewsBaihat.setAdapter(adapterSports);

        listViewsBaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String giaTriDuocChon=dsSBaihat.get(position);
                Intent intent = new Intent(Activity_Chucnang3.this, Item3Activity.class );
                intent.putExtra("Baihat_name", giaTriDuocChon);
                startActivity(intent);
            }
        });

    }
}