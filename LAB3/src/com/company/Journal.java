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
        row.notPresent(student.getSurname());
    }

    public ArrayList<Student> getListOfStudents(){
        return this.checkedStudents;
    }

    public boolean cmpPresentedStudents(ArrayList<Student> checkedStudents){
        int amount=0;
        this.checkedStudents = checkedStudents;
        for(int i = 0; i<allStudent.size();i++)
            for(int j = 0;j<checkedStudents.size();j++){
                if (allStudent.get(i).getSurname() == checkedStudents.get(j).getSurname())
                        amount++;
            }
        if(amount == allStudent.size()) return true;
        else return false;
    }

    public ArrayList<Student> addNotPresentedStudentsToList(ArrayList<Student> checkedStudents){
        this.checkedStudents = checkedStudents;
        for(int i = checkedStudents.size(); i < allStudent.size();i++){
            checkedStudents.add(new Student());
            checkedStudents.get(i).setSurname(allStudent.get(i).getSurname());
        }
        return checkedStudents;
    }

    public void setCheckedStudents(ArrayList<Student> listOfStudent){
        this.checkedStudents = listOfStudent;
    }

    public RowOfJournal getRow(){
        return row;
    }
}
