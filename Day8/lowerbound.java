import java.util.*;

public class lowerbound {

    static void addNumbers(List<? super Integer> list) {

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }

    public static void main(String[] args) {

        List<Number> numbers = new ArrayList<>();

        addNumbers(numbers);
    }
}