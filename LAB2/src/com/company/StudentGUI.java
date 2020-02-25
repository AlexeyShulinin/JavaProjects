package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentGUI extends JFrame {

    private JButton buttonUniversity = new JButton("Посетить лекцию");
    private JComboBox<String> comboBox = new JComboBox<String>();

    public static void addLectures(Lecture lecture,JComboBox<String> comboBox){
        comboBox.addItem(lecture.getTopic());
    }

    public StudentGUI(){
        super("Student");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 100);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        Container containerStudent = this.getContentPane();//содержит все поля
        containerStudent.setLayout(new GridLayout(2,0,5,5));
        containerStudent.add(comboBox);
        containerStudent.add(buttonUniversity);
    }
}
