package com.example.luyen1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button btnOk;
    void TimDieuKhien(){
        editText1=findViewById(R.id.edt1);
        editText2=findViewById(R.id.edt2);
        btnOk=findViewById(R.id.btnok);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TimDieuKhien();
       btnOk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String edit1=editText1.getText().toString();

               editText2.setText(edit1);

           }
       });

    }
}