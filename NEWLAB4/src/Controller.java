import java.util.ArrayList;

public class Controller {
    private ArrayList<Thread> carThreads;

    Controller (){
        this.carThreads = new ArrayList<Thread>(1);
    }

    public void addNewCarThread(Car car){
        carThreads.add(car.getThread());
    }

    public void addNewCarToLine(Road road){
        Car car = new Car();
        road.addCarToRoad(car);
        this.carThreads.add(car.thread);
    }

    public void cmpThreadsAndQueue(Road road){
        int i = 0;
        while (i < carThreads.size()) {
            //секция, позволяющая при обнаружении завершившегося потока, добавлять в конец массива новую машину
            if(!carThreads.get(i).isAlive()){
                road.tellInfoAboutCheatingCurrentCar(road.getCars().get(i));
                road.getCars().remove(i);
                road.addCarToRoad(new Car());
            }
            i++;
        }
    }
}
