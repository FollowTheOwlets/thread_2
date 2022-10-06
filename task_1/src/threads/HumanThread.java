package threads;

import shop.AutoShop;

import java.util.concurrent.locks.ReentrantLock;

public class HumanThread extends Thread {
    final ReentrantLock locker;
    final int MAX_SIZE = 10;
    final int SLEEP = 200;

    public HumanThread(ReentrantLock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        synchronized (AutoShop.class) {
            for (int i = 0; i < MAX_SIZE; i++) {
                System.out.println("Зашел " + "Покупатель_" + (i + 1));
                AutoShop.getInstance().addHuman("Покупатель_" + (i + 1)).goAway();
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
