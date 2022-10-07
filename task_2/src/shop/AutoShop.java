package shop;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class AutoShop {

    private final Queue<String> HUMANS;
    private final Stack<String> AUTOS;
    private static AutoShop instance = null;

    private AutoShop() {
        HUMANS = new ArrayDeque<>();
        AUTOS = new Stack<>();
    }

    public static AutoShop getInstance() {
        if (instance == null) {
            instance = new AutoShop();
        }
        return instance;
    }

    public Queue<String> getHumans() {
        return HUMANS;
    }

    public Stack<String> getAutos() {
        return AUTOS;
    }

    public AutoShop addHuman(String name) {
        HUMANS.add(name);
        return instance;
    }

    public AutoShop addAuto(String name) {
        AUTOS.push(name );
        return instance;
    }

    public void goAway() {
        if (HUMANS.isEmpty()) {
            return;
        } else if (AUTOS.isEmpty()) {
            System.out.println("Машин нет");
        } else {
            while (!HUMANS.isEmpty() && !AUTOS.isEmpty()) {
                System.out.println(HUMANS.poll() + " уехал из салона на " + AUTOS.pop());
            }

        }
    }
}
