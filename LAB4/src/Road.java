import java.util.ArrayList;

public class Road {
    private int lines = 5;
    private int countOfCheating = 0;
    private int countOfCars = 0;            //теперь можно узнать о состоянии машины(нарушила или нет),даже она уже съехала с дороги
    private int MaxSpeed;
    private ArrayList<Car> cars;
    private ArrayList<Thread> carsThreads;

    Road(){
        cars = new ArrayList<Car>(51);
        carsThreads = new ArrayList<Thread>(51);
        this.MaxSpeed = 0;
    }

    public void addCar(Car newCar){
        cars.add(newCar);
        carsThreads.add(new Thread(new CarRun(newCar)));
        carsThreads.get(carsThreads.size()-1).start();
        if(newCar.getSpeed() > 60) {
            this.countOfCheating++;
            if (newCar.getSpeed() > MaxSpeed) MaxSpeed = newCar.getSpeed();
            carsThreads.get(carsThreads.size()-1).interrupt();
            cars.remove(cars.size()-1);
            carsThreads.remove(carsThreads.size()-1);
        }
        this.countOfCars++;
    }

    public void initCountOfCheating(){
        this.countOfCheating = 0;
        this.countOfCars = 0;
        this.MaxSpeed = 0;
    }

    public int retAmount(){
        return this.countOfCars;
    }

    public void tellAboutCheating(){
        System.out.println("Кол-во нарушений: "+ this.countOfCheating);
        System.out.println("Макс скорость: "+ this.MaxSpeed);
        carsThreads.removeAll(carsThreads);
        cars.removeAll(cars);
    }
}
