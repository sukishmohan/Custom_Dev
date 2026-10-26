import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        for (int multiplier = 1; multiplier <= 10; multiplier++) {
            System.out.println(number + " x " + multiplier + " = " + (number * multiplier));
        }

        input.close();
    }
}
