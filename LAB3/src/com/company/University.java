package com.company;
import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Lecture> exercises = new ArrayList<Lecture>();
    private Headman headman = new Headman();
    private Journal journal = new Journal(students);

    public University(){
        teachers.add(new Teacher("Anna","Maximovna"));
        teachers.add(new Teacher("Milisa","Wood"));
        exercises.add(new Lecture("27.02.2020","SPOVM"));
        exercises.add(new Lecture("02.03.2020","KPP"));
        exercises.add(new Lecture("27.03.2020","APK"));
        students.add(new Student("Max","Molodcov","9|9|9"));
        students.add(new Student("Julia","Ivanova","8|8|8|9"));
        students.add(new Student("Roman","Krivoj","9|7|9"));
    }
    public University(Teacher teacher,Student student,AbstractExercise exercise,Journal journal){
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

    public void setStudents(Student student) {this.students.add(student);}

    public ArrayList<Teacher> getTeachers(){return this.teachers;}

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Headman getHeadman() {
        return headman;
    }

    public Journal getJournal(){
        return this.journal;
    }
}
