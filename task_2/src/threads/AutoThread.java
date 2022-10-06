package threads;

import shop.AutoShop;

import java.util.concurrent.locks.ReentrantLock;

public class AutoThread extends Thread {
    final ReentrantLock locker;
    final int MAX_SIZE = 10;
    final int SLEEP = 200;

    public AutoThread(ReentrantLock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_SIZE; i++) {
            locker.lock();
            System.out.println("Првезли  " + "Автомобиль_" + (i + 1));
            AutoShop.getInstance().addAuto("Автомобиль_" + (i + 1)).goAway();
            locker.unlock();

            try {
                sleep(SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
