import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFileDemo {
    public static void main(String[] args) {
        Path file = Path.of("message.txt");

        try {
            Files.writeString(file, "Hello! This text is saved in a file.");
            System.out.println("Text saved.");
        } catch (IOException e) {
            System.out.println("Could not save the file.");
        }
    }
}
