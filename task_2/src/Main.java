import threads.AutoThread;
import threads.HumanThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {


    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        List<Thread> list = new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("Покупатели");

        Thread auto = new AutoThread(locker);
        for (int i = 0; i < 10; i++) {
            list.add(new HumanThread(locker, threadGroup, "Покупатель_" + (char)(i + 65)));
        }
        list.forEach(Thread::start);
        auto.start();
    }
}
