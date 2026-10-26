import java.util.Scanner;

public class NumberTrianglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (1 to 20): ");
        int rows = scanner.nextInt();

        if (rows < 1 || rows > 20) {
            System.out.println("Please enter a number from 1 to 20.");
            return;
        }

        for (int row = 1; row <= rows; row++) {
            for (int number = 1; number <= row; number++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
