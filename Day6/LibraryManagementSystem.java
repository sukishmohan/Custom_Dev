import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LibraryManagementSystem {
    static class Book {
        private final int id;
        private final String title;
        private final String author;
        private boolean borrowed;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.borrowed = false;
        }

        int getId() { return id; }
        String getTitle() { return title; }
        String getAuthor() { return author; }
        boolean isBorrowed() { return borrowed; }
        void borrow() { borrowed = true; }
        void returnBook() { borrowed = false; }
    }

    // Checked exception: Java makes us catch it or declare it.
    static class BookNotFoundException extends Exception {
        BookNotFoundException(String message) { super(message); }
    }

    // Unchecked exception: we can catch it, but Java does not require it.
    static class DuplicateBookException extends RuntimeException {
        DuplicateBookException(String message) { super(message); }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        Set<Integer> bookIds = new HashSet<>();
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Add a book");
            System.out.println("2. Show books (sorted by title)");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Save books to a file");
            System.out.println("6. Exit");

            int choice = readNumber(input, "Choose an option: ");
            if (choice == 1) {
                addBook(input, books, bookIds);
            } else if (choice == 2) {
                showBooks(books);
            } else if (choice == 3) {
                borrowBook(input, books);
            } else if (choice == 4) {
                returnBook(input, books);
            } else if (choice == 5) {
                saveBooks(books);
            } else if (choice == 6) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Please choose a number from 1 to 6.");
            }
        }
        input.close();
    }

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

    private static void addBook(Scanner input, List<Book> books, Set<Integer> bookIds) {
        int id = readNumber(input, "Enter book ID: ");
        try {
            if (!bookIds.add(id)) {
                throw new DuplicateBookException("A book with this ID already exists.");
            }
        } catch (DuplicateBookException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("Enter book title: ");
        String title = input.nextLine();
        System.out.print("Enter author name: ");
        String author = input.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added.");
    }

    private static void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("There are no books yet.");
            return;
        }

        // Sort a copy so the original list stays as it was entered.
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        for (Book book : sortedBooks) {
            String status = book.isBorrowed() ? "Borrowed" : "Available";
            System.out.println(book.getId() + " | " + book.getTitle() + " | "
                    + book.getAuthor() + " | " + status);
        }
    }

    private static void borrowBook(Scanner input, List<Book> books) {
        int id = readNumber(input, "Enter the ID of the book to borrow: ");
        try {
            Book book = findBook(books, id);
            if (book.isBorrowed()) {
                System.out.println("This book is already borrowed.");
            } else {
                book.borrow();
                System.out.println("You borrowed " + book.getTitle() + ".");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnBook(Scanner input, List<Book> books) {
        int id = readNumber(input, "Enter the ID of the book to return: ");
        try {
            Book book = findBook(books, id);
            if (!book.isBorrowed()) {
                System.out.println("This book was not borrowed.");
            } else {
                book.returnBook();
                System.out.println("You returned " + book.getTitle() + ".");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Book findBook(List<Book> books, int id) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found.");
    }

    private static void saveBooks(List<Book> books) {
        // Java closes the file automatically when this block ends.
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("books.txt"))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor()
                        + "," + (book.isBorrowed() ? "Borrowed" : "Available"));
                writer.newLine();
            }
            System.out.println("Books saved to books.txt.");
        } catch (IOException e) {
            System.out.println("Could not save the books: " + e.getMessage());
        }
    }
}
