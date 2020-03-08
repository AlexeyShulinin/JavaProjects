package com.company;

import java.util.ArrayList;

public class Journal {
    private RowOfJournal row = new RowOfJournal();
    private ArrayList<Student> checkedStudents;
    private ArrayList<Student > allStudent;

    public Journal(ArrayList<Student> students){
        this.allStudent = students;
    }

    public void checkStudent(ArrayList<Student> students){
        row.addPresent(students);
    }

    public void notPresentStudent(Student student){
        row.notPresent(student.getName());
    }

    public ArrayList<Student> getListOfStudents(){
        return this.checkedStudents;
    }

    public boolean cmpPresentedStudents(ArrayList<Student> checkedStudents){
        int amount=0;
        for(int i = 0; i<allStudent.size();i++)
            for(int j = 0;j<checkedStudents.size();j++){
                if (allStudent.get(i).getSurname() == checkedStudents.get(j).getSurname())
                        amount++;
            }
        if(amount == allStudent.size())
            return true;
        else return false;
    }
}
