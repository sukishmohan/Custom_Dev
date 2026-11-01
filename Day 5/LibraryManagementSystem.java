import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    // A Book object stores information about one book.
    static class Book {
        private int id;
        private String title;
        private String author;
        private boolean borrowed;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.borrowed = false;
        }

        int getId() {
            return id;
        }

        String getTitle() {
            return title;
        }

        String getAuthor() {
            return author;
        }

        boolean isBorrowed() {
            return borrowed;
        }

        void borrow() {
            borrowed = true;
        }

        void returnBook() {
            borrowed = false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Add a book");
            System.out.println("2. Show all books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");

            int choice = readNumber(input, "Choose an option: ");

            if (choice == 1) {
                addBook(input, books);
            } else if (choice == 2) {
                showBooks(books);
            } else if (choice == 3) {
                borrowBook(input, books);
            } else if (choice == 4) {
                returnBook(input, books);
            } else if (choice == 5) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Please choose a number from 1 to 5.");
            }
        }

        input.close();
    }

    // Reads a number and asks again if the input is not a number.
    private static int readNumber(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            if (input.hasNextInt()) {
                int number = input.nextInt();
                input.nextLine();
                return number;
            }
            System.out.println("Please enter a whole number.");
            input.nextLine();
        }
    }

    private static void addBook(Scanner input, ArrayList<Book> books) {
        int id = readNumber(input, "Enter book ID: ");
        if (findBook(books, id) != null) {
            System.out.println("A book with this ID already exists.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = input.nextLine();
        System.out.print("Enter author name: ");
        String author = input.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added.");
    }

    private static void showBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("There are no books yet.");
            return;
        }

        for (Book book : books) {
            String status = book.isBorrowed() ? "Borrowed" : "Available";
            System.out.println(book.getId() + " | " + book.getTitle() + " | "
                    + book.getAuthor() + " | " + status);
        }
    }

    private static void borrowBook(Scanner input, ArrayList<Book> books) {
        int id = readNumber(input, "Enter the ID of the book to borrow: ");
        Book book = findBook(books, id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("This book is already borrowed.");
        } else {
            book.borrow();
            System.out.println("You borrowed " + book.getTitle() + ".");
        }
    }

    private static void returnBook(Scanner input, ArrayList<Book> books) {
        int id = readNumber(input, "Enter the ID of the book to return: ");
        Book book = findBook(books, id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isBorrowed()) {
            System.out.println("This book was not borrowed.");
        } else {
            book.returnBook();
            System.out.println("You returned " + book.getTitle() + ".");
        }
    }

    // Looks through the list and returns the book with this ID.
    private static Book findBook(ArrayList<Book> books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
