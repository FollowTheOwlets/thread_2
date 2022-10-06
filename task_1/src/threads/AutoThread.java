package threads;

import shop.AutoShop;

import java.util.concurrent.locks.ReentrantLock;

public class AutoThread extends Thread {
    final ReentrantLock locker;
    final int MAX_SIZE = 10;
    final int SLEEP = 300;

    public AutoThread(ReentrantLock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {

        synchronized (AutoShop.class) {
            for (int i = 0; i < MAX_SIZE; i++) {
                System.out.println("Привезли  " + "Автомобиль_" + (i + 1));
                AutoShop.getInstance().addAuto("Автомобиль_" + (i + 1)).goAway();
                AutoShop.class.notify();
                try {
                    sleep(SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
