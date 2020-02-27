package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UniversityGUI extends JFrame {
    private JButton buttonPlan = new JButton("Показать план лекций");
    private JButton buttonAddTeacher = new JButton("Нанять преподавателя");
    private JButton buttonAddStudent = new JButton("Зачислить студента");
    private University university = new University();


    public UniversityGUI(University university){
        super("University");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 250);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.university = university;


        Container containerUniversity = this.getContentPane();//содержит все поля
        containerUniversity.setLayout(new GridLayout(3,0,5,5));
        containerUniversity.add(buttonPlan);
        containerUniversity.add(buttonAddTeacher);
        containerUniversity.add(buttonAddStudent);

        buttonAddTeacher.addActionListener(new ButtonAddTeacherEvent());
        buttonPlan.addActionListener(new ButtonPlanEvent());
    }

    class ButtonPlanEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            PlanOfExercisesGUI addExerciseGUI = new PlanOfExercisesGUI();
            addExerciseGUI.setVisible(true);
        }
    }

    class ButtonAddTeacherEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            AddTeacherGUI addTeacherGUI = new AddTeacherGUI();
            addTeacherGUI.setVisible(true);
        }
    }

    public class PlanOfExercisesGUI extends JFrame{
        private JButton buttonAddLecture = new JButton("Добавить лекцию в расписание");
        private JButton buttonShowLecture = new JButton("Показать план лекций");
        private JLabel labelTopic = new JLabel("Предмет");
        private JLabel labelData = new JLabel("Дата");
        private JTextField getInputDate = new JTextField();
        private JTextField getInputTopic = new JTextField();

        public PlanOfExercisesGUI(){
            super("Lectures plan");//в класс JFrame передаём название нашего окна
            this.setBounds(650, 250, 425, 150);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2,2,5,5));
            panel.add(labelData);
            panel.add(getInputDate);
            panel.add(labelTopic);
            panel.add(getInputTopic);

            Container containerPlan = this.getContentPane();
            containerPlan.setLayout(new BoxLayout(containerPlan,BoxLayout.Y_AXIS));
            containerPlan.add(panel);
            containerPlan.add(buttonAddLecture);
            containerPlan.add(buttonShowLecture);

            buttonAddLecture.addActionListener(new ButtonAddLectureEvent());
            buttonShowLecture.addActionListener(new ButtonViewTableOfLectures());

        }
        class ButtonAddLectureEvent implements ActionListener {
            public void actionPerformed (ActionEvent e){
                university.setLecture(new Lecture(getInputTopic.getText(),getInputDate.getText()));
            }
        }

        class ButtonViewTableOfLectures implements ActionListener{
            public void actionPerformed (ActionEvent e){
                LectureTableGUI app = new LectureTableGUI(university);
                app.setVisible(true);
            }
        }
    }

    public class AddTeacherGUI extends JFrame{
        private JButton buttonAddTeacher = new JButton("Добавить преподавателя");
        private JButton buttonViewTableOfTeachers = new JButton("Показать учителей");
        private JLabel labelSurname = new JLabel("Фамилия");
        private JLabel labelName = new JLabel("Имя");
        private JTextField getInputSurname = new JTextField();
        private JTextField getInputName = new JTextField();

        public AddTeacherGUI(){
            super("University");//в класс JFrame передаём название нашего окна
            this.setBounds(650, 250, 425, 150);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2,2,5,5));
            panel.add(labelName);
            panel.add(getInputName);
            panel.add(labelSurname);
            panel.add(getInputSurname);

            Container containerTeacher = this.getContentPane();//содержит все поля
            containerTeacher.setLayout(new BoxLayout(containerTeacher,BoxLayout.Y_AXIS));
            containerTeacher.add(panel);
            containerTeacher.add(buttonAddTeacher);
            containerTeacher.add(buttonViewTableOfTeachers);

            buttonAddTeacher.addActionListener(new ButtonAddTeacherEvent());
            buttonViewTableOfTeachers.addActionListener(new ButtonViewTableOfTeachers());
        }

        class ButtonAddTeacherEvent implements ActionListener {
            public void actionPerformed (ActionEvent e){
                university.setTeachers(new Teacher(getInputName.getText(),getInputSurname.getText()));
            }
        }

        class ButtonViewTableOfTeachers implements ActionListener{
            public void actionPerformed (ActionEvent e){
                TeacherTableGUI app = new TeacherTableGUI(university);
                app.setVisible(true);
            }
        }

    }


}
