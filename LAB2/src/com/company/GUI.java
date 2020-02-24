package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton buttonUniversity = new JButton("Меню Университета");
    private JButton buttonStudent = new JButton("Меню студента");
    private JButton buttonTeacher = new JButton("Меню преподователя");
    private JButton buttonLecture = new JButton("Меню лекций");



    public GUI () {
        super("Second lab");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();//содержит все поля
        container.setLayout(new GridLayout(4,0));
        container.add(buttonUniversity);
        container.add(buttonStudent);
        container.add(buttonTeacher);
        container.add(buttonLecture);
    }
}