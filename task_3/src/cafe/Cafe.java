package cafe;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Thread.sleep;

public class Cafe {
    private final Queue<Order> listOrders;
    private Cooker cooker = new Cooker();
    private static Cafe instance;
    private int count;

    private Cafe() {
        listOrders = new ArrayDeque<>();
    }

    public static Cafe getInstance() {
        if (instance == null) {
            instance = new Cafe();
        }
        return instance;
    }

    public Queue<Order> getListOrders() {
        return listOrders;
    }

    public int getCount() {
        return count;
    }

    public Order getOrder() {
        Order order;
        synchronized (listOrders) {
            if (listOrders.isEmpty()) {
               return null;
            }
        }
        order = listOrders.poll();
        System.out.println(Thread.currentThread().getName() + " принял заказ");
        return order;
    }

    public void cook() {
        synchronized (cooker) {
            System.out.println("Повар начинает готовить заказ");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Повар приготовил заказ");
        }
        count++;
    }

    public void addOrder(Order order) {
        synchronized (listOrders) {
            listOrders.add(order);
            listOrders.notifyAll();
        }
    }
}
