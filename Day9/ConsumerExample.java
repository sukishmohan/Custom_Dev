import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> print = name -> System.out.println(name);

        print.accept("Java");
        print.accept("Python");
    }
}
