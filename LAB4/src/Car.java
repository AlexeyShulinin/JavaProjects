public class Car {
    private int speed;

    Car(){
        drive();
    }

    public int getSpeed(){
        return this.speed;
    }
    public void drive(){
        this.speed = (int) (Math.random() * 100);
    }
}
