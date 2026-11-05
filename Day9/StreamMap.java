import java.util.Arrays;
import java.util.List;

public class StreamMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("arun", "rahul", "karthik");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
