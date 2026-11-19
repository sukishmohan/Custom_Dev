
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("SQL");

        for (String language : list) {
            System.out.println(language);
        }

        list.add("Spring Boot");

        System.out.println("Updated List: " + list);
    }
}
