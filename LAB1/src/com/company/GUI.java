package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton button1 = new JButton("Копировать 1 в 2");
    private JButton button2 = new JButton("Копировать 2 в 3");
    private JTextField input1 = new JTextField("",5);
    private JLabel label1 = new JLabel("                 1");
    private JTextField input2 = new JTextField("",5);
    private JLabel label2 = new JLabel("                 2");
    private JTextField input3 = new JTextField("",5);
    private JLabel label3 = new JLabel("                 3");


    public GUI () {
        super("First lab");//в класс JFrame передаём название нашего окна
        this.setBounds(650,250,425,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();//содержит все поля
        container.setLayout(new GridLayout(3,3));
        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(input1);
        container.add(input2);
        container.add(input3);
        container.add(button1);
        container.add(button2);

        button1.addActionListener(new ButtonEvent1());
        button2.addActionListener(new ButtonEvent2());
    }

    class ButtonEvent1 implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String mess1 = input1.getText();
            input2.setText(mess1);
        }
    }
    class ButtonEvent2 implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String mess1 = input2.getText();
            input3.setText(mess1);
        }
    }

}
