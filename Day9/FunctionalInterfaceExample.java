@FunctionalInterface
interface Greeting {
    void sayHello();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Greeting message = () -> System.out.println("Hello Java");
        message.sayHello();
    }
}
