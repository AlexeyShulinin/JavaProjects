import java.util.ArrayList;

public class Road {
    private int lines = 5;
    private int countOfCheating = 0;
    private int countOfCars = 0;            //теперь можно узнать о состоянии машины(нарушила или нет),даже она уже съехала с дороги
    private ArrayList<Car> cars;

    Road(){
        cars = new ArrayList<Car>(51);
    }
    public ArrayList<Car> getCars(){
        return this.cars;
    }

    public void tellAboutCheating() throws InterruptedException {
//        for(int i = 0 ; i < 50 ; i++){
//            if(this.cars.get(i).getSpeed() > 60){
//                this.countOfCheating++;
//            }
//        }
        System.out.println("Кол-во нарушений: "+ this.countOfCheating);
        cars.removeAll(cars);
    }

    public int retAmount(){
        return this.countOfCars;
    }

    public void initCountOfCheating(){
        this.countOfCheating = 0;
        this.countOfCars = 0;
    }

    public void addCarToRoad(Car car){
        cars.add(car);
       // car.drive();
        this.countOfCars+=1;
    }

    public void tellInfoAboutCheatingCurrentCar(Car car) {
        if(car.getSpeed() > 60) this.countOfCheating++;
    }
}
