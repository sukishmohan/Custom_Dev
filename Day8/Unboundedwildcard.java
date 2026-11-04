import java.util.*;

public class Unboundedwildcard{

    static void display(List<?> list) {

        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Arun", "Rahul");
        List<Integer> numbers = Arrays.asList(10, 20);

        display(names);
        display(numbers);
    }
}