package com.company;

public class Controller {

    public void addNewCarToLine(Road road) throws InterruptedException {
        road.addNewCar(new Car());
    }
    public int getAmountOfCars(Road road){
        return road.retAmount();
    }
}
