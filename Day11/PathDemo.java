import java.nio.file.Files;
import java.nio.file.Path;

public class PathDemo {
    public static void main(String[] args) {
        Path file = Path.of("message.txt");

        System.out.println("File name: " + file.getFileName());
        System.out.println("Full path: " + file.toAbsolutePath());
        System.out.println("File exists: " + Files.exists(file));
    }
}
