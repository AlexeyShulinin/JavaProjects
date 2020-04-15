

import javax.swing.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller();
        Road road = new Road();
        while (true){
            controller.addNewCarToLine(road);
            controller.cmpThreadsAndQueue(road);
            if(road.retAmount() == 50) {
                road.tellAboutCheating();
                road.initCountOfCheating();
                controller.clearAllThreads();
            }
        }
    }
}