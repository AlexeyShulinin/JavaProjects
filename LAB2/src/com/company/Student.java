package com.company;
import java.util.ArrayList;


public class Student {

    private String name = new String();
    private String surname = new String();
    private String group = new String();
    private ArrayList<String> marks = new ArrayList<String>();

    public Student(){;}
    public Student(String name,String surname,String group,String mark){
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.marks.add(mark);
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return  this.surname;
    }

    public String getGroup(){
        return this.group;
    }

    public ArrayList<String> getMarks(){
        return this.marks;
    }

    public void setName(String name){
        this.name = name;
    }

    public  void setSurname(String surname){
        this.surname = surname;
    }

    public void setGroup(String group){
        this.group = group;
    }

    public void setMarks(String mark){
        this.marks.add(mark);
    }

    public int visitLecture(Lecture lecture){
        return 0;
    }
}


