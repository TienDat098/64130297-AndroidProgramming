package com.example.a64130297_thigiuaky;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Activity_Chucnang4 extends AppCompatActivity {
    HDadapter HDAdapter;
    ArrayList<HoatDong> recyclerViewDaTas;
    RecyclerView recyclerViewHD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang4);

    }
}