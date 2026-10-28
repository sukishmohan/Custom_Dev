import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter words separated by spaces: ");
        String sentence = input.nextLine().trim().toLowerCase();

        if (sentence.isEmpty()) {
            System.out.println("No words entered.");
            return;
        }

        String[] words = sentence.split("\\s+");
        boolean[] counted = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (counted[i]) {
                continue;
            }

            int count = 0;
            for (int j = i; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    counted[j] = true;
                }
            }
            System.out.println(words[i] + ": " + count);
        }
    }
}
