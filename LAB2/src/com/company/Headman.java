package com.company;

import java.util.ArrayList;

public class Headman extends  Student {

    ArrayList<Student> checkedStudent = new ArrayList<Student>();

    public void checkStudent(University allStudents,Student student){
        for(int i = 0; i < allStudents.getCountOfStudents();i++){
            if(student.getName() == allStudents.getStudent(i).getName() && student.getSurname() == allStudents.getStudent(i).getSurname())
                checkedStudent.add(student);
        }
    }
}
