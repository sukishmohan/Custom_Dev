import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Arun", "Rahul", "Karthik");
        names.forEach(System.out::println);
    }
}
