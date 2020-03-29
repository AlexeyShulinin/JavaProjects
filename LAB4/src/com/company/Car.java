package com.company;

public class Car {
    private int speed;
    private boolean drive;
    private String name;
    Thread thread;

    public Car() throws InterruptedException {
        this.thread = new Thread();
        this.name = this.thread.getName();
        this.speed = 0;
        this.drive = true;
        driveACar();
    }

    public void driveACar()  throws InterruptedException {
        this.thread.start();
        this.speed = (int) (Math.random() * 100);
        System.out.println(this.thread.getName() + "(" + this.thread.getId() +")" + ":" + this.speed);
        if (this.getSpeed() <= 60) {
            Thread.sleep(1000);
        }
        this.thread.interrupt();
    }

    public int getSpeed(){return this.speed;}

    public String getInfoAboutCar(){
        return this.name + " : " + this.speed;
    }

    public void changeStatusToStop(){
        this.drive = false;
    }

}
