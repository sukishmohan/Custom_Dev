import java.util.*;

public class upperbound {

    static double calculateTotal(List<? extends Number> numbers) {

        double total = 0;

        for (Number n : numbers) {
            total += n.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30);

        System.out.println(calculateTotal(numbers));
    }
}