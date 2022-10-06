package workers;

import cafe.Cafe;
import cafe.Order;

public class Officiant extends Thread {
    private ThreadGroup threadGroup;

    public Officiant(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
        this.threadGroup = threadGroup;
    }

    @Override
    public void run() {
        while (Cafe.getInstance().getCount() < 5) {
            Order order;
            synchronized (Cafe.getInstance().getListOrders()) {
                order = Cafe.getInstance().getOrder();
            }
            if (order == null) continue;
            Cafe.getInstance().cook();
            System.out.println(getName() + " вынес заказ гостям");
            synchronized (order) {
                order.notify();
            }
        }
        synchronized (Cafe.getInstance().getListOrders()) {
            Cafe.getInstance().getListOrders().notifyAll();
        }
        threadGroup.interrupt();
    }
}