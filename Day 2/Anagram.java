import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first word or phrase: ");
        String first = input.nextLine().toLowerCase().replace(" ", "");
        System.out.print("Enter the second word or phrase: ");
        String second = input.nextLine().toLowerCase().replace(" ", "");

        char[] firstLetters = first.toCharArray();
        char[] secondLetters = second.toCharArray();
        Arrays.sort(firstLetters);
        Arrays.sort(secondLetters);

        if (Arrays.equals(firstLetters, secondLetters)) {
            System.out.println("They are anagrams.");
        } else {
            System.out.println("They are not anagrams.");
        }
    }
}
