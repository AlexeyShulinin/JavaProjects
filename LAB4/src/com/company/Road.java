package com.company;

import java.util.ArrayDeque;

public class Road {
    private int lines;
    private ArrayDeque<Car> carArrayDeque;

    public Road(){
        carArrayDeque = new ArrayDeque<Car>(51);
        this.lines = 5;
    }

    public void addNewCar(Car newCar){
        this.carArrayDeque.add(newCar);
    }

    public void tellAboutCheating(){
        if(this.carArrayDeque.getFirst().getSpeed() > 60)
            System.out.println("Имеются нарушения");
    }

    public int retAmount(){
        return this.carArrayDeque.size();
    }

    public String getInfo(){
        String info = carArrayDeque.getFirst().getInfoAboutCar();
        Thread t = carArrayDeque.getFirst().retThread();
        if (carArrayDeque.getFirst().getSpeed() > 60){
            try{
                t.join();
            }
            catch (InterruptedException e){
                System.out.printf("%s has been interrupted", t.getName());
            }
            carArrayDeque.removeFirst();
        }
        else {
            try {
                t.sleep(1000);
                t.join();
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted", t.getName());
            }
            carArrayDeque.removeFirst();
        }
        return info;
    }
}
