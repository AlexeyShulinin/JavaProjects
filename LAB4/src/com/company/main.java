package com.company;

import javax.swing.*;

public class main {
    public static void main(String[] args){
        Controller controller = new Controller();
        Road road = new Road();
        while(true){
            controller.addNewCarToLine(road);
            if(controller.getAmountOfCars(road) == 50)
                for(int i = 0; i < 50;i++) {
                    road.tellAboutCheating();
                    System.out.println(road.getInfo());
                }
        }
    }
}
