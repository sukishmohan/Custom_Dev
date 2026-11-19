
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args)
            throws InterruptedException {

        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {
            map.put(1, "Java");
            map.put(2, "Python");
        });

        Thread t2 = new Thread(() -> {
            map.put(3, "SQL");
            map.put(4, "Spring Boot");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map);
    }
}
