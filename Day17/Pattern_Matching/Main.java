public class Main {
    static String describe(Object value) {
        return switch (value) {
            case Integer number -> "Integer: " + number;
            case String text -> "String: " + text;
            case Double decimal -> "Double: " + decimal;
            case null -> "Value is null";
            default -> "Unknown type";
        };
    }

    public static void main(String[] args) {
        Object value = "Hello Java";

        if (value instanceof String text) {
            System.out.println("Text length: " + text.length());
        }

        System.out.println(describe(100));
        System.out.println(describe("Java"));
        System.out.println(describe(10.5));
        System.out.println(describe(null));
    }
}
