public class Car {
    private int speed;
    boolean isCheated = false;

    Car(){
        this.speed = (int) (Math.random() * 100);
    }

    public int getSpeed(){
        return this.speed;
    }
}
