import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> employees = new HashMap<>();

        employees.put(101, "Lokesh");
        employees.put(102, "Amar");
        employees.put(103, "Surya");
        employees.put(101, "Suki");

        System.out.println(employees);
        System.out.println(employees.get(102));
        System.out.println(employees.containsKey(103));
        System.out.println(employees.size());
    }
}
