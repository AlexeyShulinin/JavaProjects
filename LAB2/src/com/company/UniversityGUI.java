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
    private ArrayList<Teacher> listOfTeachers = new ArrayList<Teacher>();

    Object[] col = new String[]{"Name","Surname"};

    DefaultTableModel tableModel = new DefaultTableModel(0,2);

    JTable table = new JTable(tableModel);

    public UniversityGUI(){
        super("University");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 250);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        listOfTeachers = university.getTeachers();

        Container containerUniversity = this.getContentPane();//содержит все поля
        containerUniversity.setLayout(new GridLayout(3,0,5,5));
        containerUniversity.add(buttonPlan);
        containerUniversity.add(buttonAddTeacher);
        containerUniversity.add(buttonAddStudent);

        buttonAddTeacher.addActionListener(new ButtonAddTeacherEvent());
    }

    class ButtonPlanEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){

        }
    }

    class ButtonAddTeacherEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            AddTeacherGUI addTeacherGUI = new AddTeacherGUI();
            addTeacherGUI.setVisible(true);
        }
    }

    public class AddTeacherGUI extends JFrame{
        private JButton buttonAddTeacher = new JButton("Добавить преподавателя");
        private JLabel labelSurname = new JLabel("Фамилия");
        private JLabel labelName = new JLabel("Имя");
        private JTextField getInputSurname = new JTextField();
        private JTextField getInputName = new JTextField();

        public AddTeacherGUI(){
            super("University");//в класс JFrame передаём название нашего окна
            this.setBounds(650, 250, 425, 175);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            tableModel.setColumnIdentifiers(col);

            if (tableModel.getRowCount() == 0) {

                for (int i = 0; i < listOfTeachers.size(); i++) {
                    Object[] obj = {listOfTeachers.get(i).getName(), listOfTeachers.get(i).getSurname()};
                    tableModel.addRow(obj);
                }
            }

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2,2,5,5));
            panel.add(labelName);
            panel.add(getInputName);
            panel.add(labelSurname);
            panel.add(getInputSurname);

            Container containerTeacher = this.getContentPane();//содержит все поля
            containerTeacher.setLayout(new BoxLayout(containerTeacher,BoxLayout.Y_AXIS));
            containerTeacher.add(table);
            containerTeacher.add(panel);
            containerTeacher.add(buttonAddTeacher);

            buttonAddTeacher.addActionListener(new ButtonAddTeacherEvent());

        }

        class ButtonAddTeacherEvent implements ActionListener {
            public void actionPerformed (ActionEvent e){
                university.setTeachers(new Teacher(getInputName.getText(),getInputSurname.getText()));
                Object[] obj = { listOfTeachers.get(listOfTeachers.size()-1).getName(), listOfTeachers.get(listOfTeachers.size()-1).getSurname()};
                tableModel.addRow(obj);
            }
        }

    }


}
