import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new TreeMap<>();

        students.put(103, "Lokesh");
        students.put(101, "Amar");
        students.put(102, "Surya");

        System.out.println(students);
    }
}
