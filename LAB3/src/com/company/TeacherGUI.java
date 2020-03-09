package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherGUI extends JFrame {
    private JButton buttonTellLecture = new JButton("Провести лекцию");
    private JButton buttonCheckStudentsFromHeadman = new JButton("Отметить старосту");
    private JButton buttonCheckStudent = new JButton("Проверить студетов");
    private JButton buttonCMPListOfStudents = new JButton("Сравнить списки");
    private JLabel labelIndicatorStudents = new JLabel("Сравнение студентов");
    private JLabel labelIndicator = new JLabel("Вы пока не провели лекцию");
    private ArrayList<Lecture> listExercise = new ArrayList<Lecture>();
    private Journal journal;
    private University university;
    private JComboBox<String> comboBoxLectures = new JComboBox<String>();
    private JComboBox<String> comboBoxStudents = new JComboBox<String>();


    public TeacherGUI(University university){
        super("Teacher");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 475, 175);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.university = university;
        this.journal = university.getJournal();
        this.listExercise = university.getLecture();

        StudentGUI.addLectures(this.listExercise,this.comboBoxLectures);


        Container containerTeacher = this.getContentPane();//содержит все поля
        containerTeacher.setLayout(new GridLayout(4,0,5,5));
        containerTeacher.add(comboBoxLectures);
        containerTeacher.add(labelIndicator);
        containerTeacher.add(buttonTellLecture);
        containerTeacher.add(buttonCheckStudent);
        containerTeacher.add(buttonCheckStudentsFromHeadman);
        containerTeacher.add(comboBoxStudents);
        containerTeacher.add(buttonCMPListOfStudents);
        containerTeacher.add(labelIndicatorStudents);

        buttonTellLecture.addActionListener(new ButtonShowLecturesEvent());
        buttonCheckStudent.addActionListener(new ButtonShowStudentsEvent());
        buttonCheckStudentsFromHeadman.addActionListener(new ButtonShowHeadmanEvent());
        buttonCMPListOfStudents.addActionListener(new ButtonCMPStudents());
    }

    class ButtonShowLecturesEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            labelIndicator.setText("Ура! вы провели :" + comboBoxLectures.getSelectedItem());
        }
    }

    class ButtonShowStudentsEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            ArrayList<Student> listOfStudent = listExercise.get(comboBoxLectures.getSelectedIndex()).getPresentStudents();
            HeadmanGUI.addStudents(listOfStudent,comboBoxStudents);
            journal.setCheckedStudents(listOfStudent);
        }
    }

    class ButtonShowHeadmanEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            HeadmanGUI.addMe(university.getHeadman().getHeadman(),comboBoxStudents);
        }
    }

    class ButtonCMPStudents implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (university.getStudents().size() != 0 && journal.getListOfStudents().size() != 0) {
                if (university.getJournal().cmpPresentedStudents(journal.getListOfStudents()) == true) {
                    labelIndicatorStudents.setText("Всё в норме");
                    university.getHeadman().setResultOfCMP(true);
                } else {
                    labelIndicatorStudents.setText("Списки не равны");
                    university.getHeadman().setResultOfCMP(false);
                }
            }
        }
    }
}
