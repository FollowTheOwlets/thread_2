package threads;

import shop.AutoShop;

import java.util.concurrent.locks.ReentrantLock;

public class HumanThread extends Thread {
    final ReentrantLock locker;
    final int SLEEP = 200;

    public HumanThread(ReentrantLock locker, ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        System.out.println("Зашел " + getName());
        AutoShop.getInstance().addHuman(getName()).goAway();
        locker.unlock();
        try {
            sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
