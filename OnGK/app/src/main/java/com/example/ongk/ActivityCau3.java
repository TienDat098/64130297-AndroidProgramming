package com.example.ongk;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Tạo lớp Course khai báo biến, getter,setter,khởi tạo constructor
//tạo 1 item_course gắn image,caption....
//trong layout chính gắn recycler (điều chỉnh phù hợp như chiều cao, rộng)
//tạo Adapter(lớp) kế thừa từ RecyclerView.adapter
   //xây dựng ViewHolder
    //hàm khởi tạo bấm bên trái class rồi chọn cái đầu tiên
    //tim đều khiển
//xử lý implement OnclickListener trong viewHolder trong lớp CourseAdapter
//dữ liệu onClick
// thêm cardView vào item_Course chứa 2 đk còn lại
public class ActivityCau3 extends AppCompatActivity {
    CourseAdapter courseAdapter;
    ArrayList<Course> recyclerViewDaTas;
    RecyclerView recyclerViewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cau3);
        //3
        recyclerViewDaTas=getDataForRecyclerView();
        //4
        recyclerViewCourse =findViewById(R.id.recyclerCourse);
        //5
        RecyclerView.LayoutManager layoutLinear =new LinearLayoutManager(this);
        recyclerViewCourse.setLayoutManager(layoutLinear);
        //6
        courseAdapter =new CourseAdapter(this,recyclerViewDaTas);
        //7
        recyclerViewCourse.setAdapter(courseAdapter);

    }
    ArrayList<Course> getDataForRecyclerView(){
        ArrayList<Course> dsDuLieu= new ArrayList<Course>();
        Course course1=new Course("Khóa học lập trình python","khoa_lt_python");
        dsDuLieu.add(course1);
        dsDuLieu.add(new Course("Khóa học lập trình .NET","khoa_lt_net"));
        dsDuLieu.add(new Course("Khóa học lập trình Java","khoa_lt_java"));
        dsDuLieu.add(new Course("Khóa học lập trình Android","khoa_lt_android"));
        return dsDuLieu;
    }
}