package com.company;

import java.util.ArrayList;

public class Lecture extends AbstractExercise{
    private String topic = new String();
    private ArrayList<Student> presentStudents = new ArrayList<Student>();

    public Lecture(){;}

    public Lecture(String date,String topic){
        super(date);
        this.topic = topic;
    }

    public void setLecture (String newData,String newTopic){
        this.setDate(newData);
        this.topic = newTopic;
    }

    public String getTopic (){
        return this.topic;
    }
    public String retKnowledge () { return "Вернуть знания"; }
    public String addPresentStudent(Student student){
        presentStudents.add(student);
        return retKnowledge();
    }

    public ArrayList<Student> getPresentStudents(){
        return presentStudents;
    }

}
