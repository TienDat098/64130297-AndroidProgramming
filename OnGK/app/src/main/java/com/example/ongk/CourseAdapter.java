package com.example.ongk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ItemCourseHolder> {
    Context context;
    ArrayList<Course> lstData;

    public CourseAdapter(Context context, ArrayList<Course> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemCourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vItem = inflater.inflate(R.layout.item_course, parent, false);
        return new ItemCourseHolder(vItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCourseHolder holder, int position) {
        Course courseHienThi = lstData.get(position);
        String name = courseHienThi.getCourseName();
        String tenFileAnh = courseHienThi.getCourseImageFileName();

        holder.tvName.setText(name);

        // Lấy ID ảnh từ mipmap
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivCourse.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemCourseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        ImageView ivCourse;

        public ItemCourseHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textViewCourse);
            ivCourse = itemView.findViewById(R.id.imageViewCourse);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriDuocClick = getAdapterPosition();
            Course phanTuDuocClick = lstData.get(viTriDuocClick);

            String ten = phanTuDuocClick.getCourseName();
            String tenFile = phanTuDuocClick.getCourseImageFileName();

            // Chuyển qua CustomItemActivity
            Intent intent = new Intent(v.getContext(), CustomItemActivity.class);
            intent.putExtra("course_name", ten);
            intent.putExtra("course_image", tenFile);
            v.getContext().startActivity(intent);
        }
    }
}
