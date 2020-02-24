package com.company;
import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Lecture> lectures = new ArrayList<Lecture>();

    public void enrollStudent(Student newStudent){
        this.students.add(newStudent);
    }

    public void hireTeacher(Teacher newTeacher){
        this.teachers.add(newTeacher);
    }

    public void makePlanLectures(){
        
    }

}
