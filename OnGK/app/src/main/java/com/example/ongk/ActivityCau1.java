package com.example.ongk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityCau1 extends AppCompatActivity {
    EditText  editTextSoA,editTextSoB, editTextKetQua;
    Button btnCong;

    public  void TimDieuKhien(){
        editTextSoA = findViewById(R.id.edtA);
        editTextSoB = findViewById(R.id.edtB);
        editTextKetQua = findViewById(R.id.edtKQ);
        btnCong=findViewById(R.id.btnCong);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);
        TimDieuKhien();

            btnCong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strA =editTextSoA.getText().toString();
                    String strB =editTextSoB.getText().toString();
                    int so_A=Integer.parseInt(strA);
                    int so_B=Integer.parseInt(strB);
                    int tong=  so_A + so_B;
                    String strTong =String.valueOf(tong);
                    editTextKetQua.setText(strTong);
                    editTextKetQua.setEnabled(false);
                }
            });
        }
    }
