import java.util.ArrayList;

public class Controller {
    private ArrayList<Thread> carThreads;
    private int countOfThreads;

    Controller (){
        this.carThreads = new ArrayList<Thread>(51);
        this.countOfThreads = 0;
    }

    public void addNewCarThread(Car car){
        carThreads.add(car.getThread());
    }

    public void addNewCarToLine(Road road) throws InterruptedException {
        Car car = new Car();
        road.addCarToRoad(car);
        road.tellInfoAboutCheatingCurrentCar(car);
        this.carThreads.add(car.thread);
        this.countOfThreads++;
    }

    public void cmpThreadsAndQueue(Road road) throws InterruptedException {
        int i = 0;
        while (i < this.countOfThreads) {
            //секция, позволяющая при обнаружении завершившегося потока, добавлять в конец массива новую машину
            if(!carThreads.get(i).isAlive()){
                road.getCars().remove(i);
                this.carThreads.remove(i);
                this.countOfThreads--;
                addNewCarToLine(road);
            }
            i++;
        }
    }

    public void clearAllThreads() throws InterruptedException {
        this.countOfThreads = 0;
        System.out.println("XXX");
        Thread.currentThread().join();
        System.out.println("YYY");
        this.carThreads.removeAll(carThreads);
    }
}
