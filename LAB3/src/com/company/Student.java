package com.company;
import java.util.ArrayList;


public class Student extends AbstractStudent {
    private String marks = new String();

    public Student(){;}

    public Student(String newName,String newSurname,String mark){
        super(newName,newSurname);
        this.marks = mark;
    }



    public String getMarks(){
        return this.marks;
    }

    public void setMarks(String mark){
        this.marks += "|" + mark;
    }


    public void setStudent(Student student) {
        this.setName(student.getName());
        this.setSurname(student.getSurname());
    }

    public String retThanks(){ return "Thank u";}
}


