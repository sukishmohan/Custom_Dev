import java.util.Scanner;

public class WrapperClasses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a whole number: ");
        String text = input.nextLine();

        int primitiveNumber = Integer.parseInt(text);
        Integer wrappedNumber = Integer.valueOf(text);
        String convertedBack = wrappedNumber.toString();

        System.out.println("Primitive int: " + primitiveNumber);
        System.out.println("Integer object: " + wrappedNumber);
        System.out.println("Back to String: " + convertedBack);
    }
}
