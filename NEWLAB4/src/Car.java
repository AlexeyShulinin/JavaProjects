public class Car{
    private int speed;
    private String name;
    Thread thread;

    public Car() throws InterruptedException {
        this.name = Thread.currentThread().getName();
        this.speed = (int) (Math.random() * 100);
        thread = new Thread(new Runnable() {
            int tmpSpeed;
            //эту функцию выполнает созданный поток и запускается её работа в мутоде drive()
            @Override
            public void run() {
                tmpSpeed = getSpeed();

                System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getId() +")" + ":" + this.tmpSpeed);
                if (tmpSpeed <= 60) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.currentThread().interrupt();

            }
        });
        thread.start();
       // thread.join();
    }

    public void drive(){
        this.thread.start();
    }

    public int getSpeed(){
        return this.speed;
    }

    public Thread getThread(){
        return this.thread;
    }

}
