import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number from 0 to 20: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 20) {
            System.out.println("Please enter a number from 0 to 20.");
            return;
        }

        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        System.out.println(number + "! = " + factorial);
    }
}
