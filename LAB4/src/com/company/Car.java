package com.company;

public class Car {
    private int speed;
    private String name;
    Thread thread;

    public Car(){
        this.thread = new Thread();
        this.name = this.thread.getName();
        this.speed = 0;
        driveACar();
    }
    public void driveACar(){
        this.speed += (int)(Math.random()*100);
    }
    public int getSpeed(){return this.speed;}

    public String getInfoAboutCar(){
        return this.name + " : " + this.speed;
    }
}
