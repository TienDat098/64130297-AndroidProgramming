package com.example.vieccanlam;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASKS> lstVCL;
    TaskRVadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tạo kết nối đến CSDL
        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=database.getReference("TASKS");
        //Lắng nghe và xử lý
        lstVCL= new ArrayList<TASKS>();
        databaseReference.addValueEventListener(ngheFB);

        //Tìm điều khiển
        RecyclerView recyclerView=findViewById(R.id.rcvVCL);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter= new TaskRVadapter(lstVCL);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    ValueEventListener ngheFB=new ValueEventListener() {
        // @Override
        // public void onDataChange(@NonNull DataSnapshot snapshot) {
        //Lấy dữ liệu từ bến snapshot , đưa vào một biến danh sách để xử lý
        //   for(DataSnapshot obj: snapshot.getChildren()){
        //       TASKS tasks =obj.getValue(TASKS.class);
        //       lstVCL.add(tasks);
        //       Log.w("VCL app","Tên việc cần làm: "+ tasks.getName());
        //    }
        // }


        //do xóa 1 node trong FireBase trước khi tạo 2 node nên bị lỗi null nên ta kiểm tra null
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot obj : snapshot.getChildren()) {
                try {
                    TASKS tasks = obj.getValue(TASKS.class);
                    if (tasks != null) {
                        lstVCL.add(tasks);
                        Log.w("VCL app", "Tên việc cần làm: " + tasks.getName());
                    } else {
                        Log.e("VCL app", "Không đọc được TASKS từ: " + obj.toString());
                    }
                } catch (Exception e) {
                    Log.e("VCL app", "Lỗi parse dữ liệu Firebase: ", e);
                }
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

}