import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many terms (1 to 20)? ");
        int terms = scanner.nextInt();

        if (terms < 1 || terms > 20) {
            System.out.println("Please enter a number from 1 to 20.");
            return;
        }

        int first = 0;
        int second = 1;
        System.out.print("Fibonacci series: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first);
            if (i < terms) {
                System.out.print(" ");
            }
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}
