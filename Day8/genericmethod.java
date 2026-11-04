public class Main {

    public static <T> void display(T value) {

        System.out.println(value);
    }

    public static void main(String[] args) {

        display("Java");
        display(100);
        display(25.5);
    }
}