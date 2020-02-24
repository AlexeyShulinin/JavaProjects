package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton button1 = new JButton("Копировать 1 в 2");
    private JButton button2 = new JButton("Копировать 2 в 3");
    private JTextField input1 = new JTextField("",5);
    private JLabel label1 = new JLabel("1");
    private JTextField input2 = new JTextField("",5);
    private JLabel label2 = new JLabel("2");
    private JTextField input3 = new JTextField("",5);
    private JLabel label3 = new JLabel("3");


    public GUI () {
        super("First lab");//в класс JFrame передаём название нашего окна
        this.setBounds(650,250,425,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(label1);
        panel1.add(input1);
        panel1.add(button1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(label2);
        panel2.add(input2);
        panel2.add(button2);

        JPanel panel3 = new JPanel();
        JPanel x = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(label3);
        panel3.add(input3);
        panel3.add(x);


        Container container = this.getContentPane();//содержит все поля
        container.setLayout(new GridLayout());
        container.add(panel1);
        container.add(panel2);
        container.add(panel3);

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
