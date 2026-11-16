import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {
    static class Student implements Serializable {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " is " + age + " years old.";
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Mia", 20);

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("student.ser"))) {
            output.writeObject(student);
        } catch (IOException e) {
            System.out.println("Could not save the student.");
            return;
        }

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("student.ser"))) {
            Student savedStudent = (Student) input.readObject();
            System.out.println(savedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not read the student.");
        }
    }
}
