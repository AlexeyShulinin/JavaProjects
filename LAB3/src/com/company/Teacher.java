package com.company;

import java.util.ArrayList;

public class Teacher {
    private String name = new String();
    private String surname = new String();

    ArrayList<Student> checkedStudent = new ArrayList<Student>();

    public Teacher(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public int readLecture(Lecture lecture){
        return 0;
    }

    public void checkStudent(University allStudents,Student student,Journal journal){
        for(int i = 0; i < allStudents.getCountOfStudents();i++){
            if(student.getName() == allStudents.getStudent(i).getName() && student.getSurname() == allStudents.getStudent(i).getSurname()) {
                checkedStudent.add(student);
            }
        }
        journal.getRow().addPresent(checkedStudent);
    }

    public void setInfo(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getInfo(){
        return this.name + " " + this.surname;
    }
    public String getName() { return this.name; }
    public String getSurname() { return  this.surname; }

    public ArrayList<Student> getListOfStudents(Journal journal){
        return journal.getListOfStudents();
    }
}
