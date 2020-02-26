package com.company;
import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

    public University(){
        teachers.add(new Teacher("Anna","Maximovna"));
        teachers.add(new Teacher("Milisa","Wood"));
    }
    public University(Teacher teacher,Student student,Exercise exercise){
        teachers.add(teacher);
    }

    public void enrollStudent(Student newStudent){
        this.students.add(newStudent);
    }

    public void hireTeacher(Teacher newTeacher){
        this.teachers.add(newTeacher);
    }

    public void makePlanLectures(Exercise newExercise){
        this.exercises.add(newExercise);
    }

    public int getCountOfStudents(){
        return students.size();
    }

    public Student getStudent(int pos){
        return students.get(pos);
    }

    public ArrayList<Exercise> getExercises(){
        return this.exercises;
    }

    public void setTeachers(Teacher teacher){
        this.teachers.add(teacher);
    }

    public ArrayList<Teacher> getTeachers(){return this.teachers;}

}
