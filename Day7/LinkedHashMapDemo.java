import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new LinkedHashMap<>();

        students.put(3, "Lokesh");
        students.put(1, "Amar");
        students.put(2, "Surya");

        System.out.println(students);
    }
}
