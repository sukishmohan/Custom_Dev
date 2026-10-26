import java.util.Scanner;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Show prime numbers up to: ");
        int limit = scanner.nextInt();

        System.out.print("Prime numbers: ");
        for (int number = 2; number <= limit; number++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= number / divisor; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
