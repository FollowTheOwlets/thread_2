import threads.AutoThread;
import threads.HumanThread;

import java.util.concurrent.locks.ReentrantLock;

public class Main {


    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();

        Thread auto = new AutoThread(locker);
        Thread human = new HumanThread(locker);

        human.start();
        auto.start();
    }
}
