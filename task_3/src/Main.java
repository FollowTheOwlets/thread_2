import workers.Officiant;
import workers.Visitor;

public class Main {
    static final int offCount = 3;
    static final int visCount = 5;
    public static void main(String[] args) {
        ThreadGroup  threadGroup= new ThreadGroup("Cafe");

        for (int i = 0; i < offCount; i++) {
            new Officiant(threadGroup,"Официант-" + (i + 1)).start();
        }

        for (int i = 0; i < visCount; i++) {
            new Visitor("Посетитель-" + (i + 1)).start();
        }

    }
}
