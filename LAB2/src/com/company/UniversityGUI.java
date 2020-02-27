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
            new PlanOfExercisesGUI();
        }
    }

    class ButtonAddTeacherEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            new AddTeacherGUI();
        }
    }

    public class PlanOfExercisesGUI{
        public PlanOfExercisesGUI() {
            TemplateAddGUI addLectureGUI = new TemplateAddGUI(
                    "Add new lecture",
                    "Добавить лекцию в расписание",
                    "Показать план лекций",
                    "Дата",
                    "Предмет",
                    "addNewLecture",
                    university);
            addLectureGUI.setVisible(true);
        }
    }

    public class AddTeacherGUI {
        public AddTeacherGUI() {
            TemplateAddGUI addTeacherGUI = new TemplateAddGUI(
                    "Add new teacher",
                    "Добавить преподавателя",
                    "Показать учителей",
                    "Имя",
                    "Фамилия",
                    "addNewTeacher",
                    university);
            addTeacherGUI.setVisible(true);
        }
    }
}
