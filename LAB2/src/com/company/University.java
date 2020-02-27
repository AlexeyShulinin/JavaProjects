package com.company;
import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Lecture> exercises = new ArrayList<Lecture>();

    public University(){
        teachers.add(new Teacher("Anna","Maximovna"));
        teachers.add(new Teacher("Milisa","Wood"));
        exercises.add(new Lecture("27.02.2020","SPOVM"));
        exercises.add(new Lecture("02.03.2020","KPP"));
        exercises.add(new Lecture("27.03.2020","APK"));
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

    public void makePlanLectures(Lecture newExercise){
        this.exercises.add(newExercise);
    }

    public int getCountOfStudents(){
        return students.size();
    }

    public Student getStudent(int pos){
        return students.get(pos);
    }

    public ArrayList<Lecture> getLecture(){
        return this.exercises;
    }

    public void setLecture(Lecture lecture){ this.exercises.add(lecture);}

    public void setTeachers(Teacher teacher){
        this.teachers.add(teacher);
    }

    public ArrayList<Teacher> getTeachers(){return this.teachers;}

}
