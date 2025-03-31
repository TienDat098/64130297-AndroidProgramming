package com.example.ongk;

public class Course {
    String CourseName;
    String  CourseImageFileName;

    public Course(String courseName, String courseImageFileName) {

        CourseImageFileName = courseImageFileName;
        CourseName = courseName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseImageFileName() {
        return CourseImageFileName;
    }

    public void setCourseImageFileName(String courseImageFileName) {
        CourseImageFileName = courseImageFileName;
    }
}
