import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileDemo {
    public static void main(String[] args) {
        Path file = Path.of("message.txt");

        try {
            String text = Files.readString(file);
            System.out.println(text);
        } catch (IOException e) {
            System.out.println("Could not read the file. Run WriteFileDemo first.");
        }
    }
}
