package com.company;


import java.util.ArrayList;

public class RowOfJournal {
    private String nameOfStudent = new String();
    private ArrayList<String> presence = new ArrayList<String>();
    private int amount = 0;

    public void addPresent(ArrayList<Student> namesOfStudents){
        for(int i = 0; i < namesOfStudents.size();i++)
            this.presence.add(namesOfStudents.get(i).getName() + "+");
    }

    public void notPresent(String nameOfStudent){
        this.presence.add(nameOfStudent + "-");
    }




}
