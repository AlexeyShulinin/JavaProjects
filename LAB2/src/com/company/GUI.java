package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton buttonUniversity = new JButton("Меню Университета");
    private JButton buttonStudent = new JButton("Меню студента");
    private JButton buttonTeacher = new JButton("Меню преподователя");
    private JButton buttonLecture = new JButton("Меню лекций");
    private JButton buttonHeadman = new JButton("Меню старосты");
    private University university = new University();




    public GUI () {
        super("Second lab");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();//содержит все поля
        container.setLayout(new GridLayout(5,0,5,5));
        container.add(buttonUniversity);
        container.add(buttonLecture);
        container.add(buttonTeacher);
        container.add(buttonStudent);
        container.add(buttonHeadman);

        buttonStudent.addActionListener(new ButtonStudentEvent());
        buttonLecture.addActionListener(new ButtonLectureEvent());
        buttonTeacher.addActionListener(new ButtonTeacherEvent());
        buttonUniversity.addActionListener(new ButtonUniversityEvent());
        buttonHeadman.addActionListener(new ButtonHeadmanEvent());
    }

    class ButtonStudentEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            StudentGUI studentGUI = new StudentGUI();
            studentGUI.setVisible(true);
        }
    }

    class ButtonLectureEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){

        }
    }

    class ButtonTeacherEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){

        }
    }

    class ButtonUniversityEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            UniversityGUI universityGUI = new UniversityGUI(university);
            universityGUI.setVisible(true);
        }
    }

    class ButtonHeadmanEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){

        }
    }
}