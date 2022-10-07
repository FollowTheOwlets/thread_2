package workers;

import cafe.Cafe;
import cafe.Order;

public class Visitor extends Thread {
    final Order order = new Order();
    final int sleep = 100;
    public Visitor(String name) {
        super( name);
    }

    @Override
    public void run() {
            synchronized (order) {
                System.out.println(Thread.currentThread().getName() + " в ресторане");

                Cafe.getInstance().addOrder(order);
                try {
                    order.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " приступил к приему пищи");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " покинул ресторан");
            }
    }
}
