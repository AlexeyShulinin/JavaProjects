package com.company;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Road {
    private int lines = 5;
    private int countOfCheating = 0;
    private ArrayList<Car> cars;

    public Road(){
        cars = new ArrayList<Car>(50);
    }

    public void addNewCar(Car newCar) throws InterruptedException {
        this.cars.add(newCar);
    }

    public void tellAboutCheating() throws InterruptedException {
       for(int i = 0 ; i < 50 ; i++){
           this.cars.get(i).changeStatusToStop();
            if(this.cars.get(i).getSpeed() > 60){
                this.countOfCheating++;
            }
        }
        System.out.println("Кол-во нарушений: "+ this.countOfCheating);
        cars.clear();
    }

    public int retAmount(){
        return this.cars.size();
    }

    public void initCountOfCheating(){
        this.countOfCheating = 0;
    }


}
