import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> message = () -> "Welcome to Java";
        System.out.println(message.get());
    }
}
