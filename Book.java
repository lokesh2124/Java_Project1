import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

class Book {
    private String title;
    private String author;
    private boolean issued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }
}

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(String title, String author) {
        String uniqueCode = generateUniqueCode();
        Book book = new Book(title, author);
        books.put(uniqueCode, book);
        System.out.println("Book added. Unique Code: " + uniqueCode);
    }

    public void issueBook(String uniqueCode) {
        Book book = books.get(uniqueCode);
        if (book != null) {
            if (!book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued: " + book.getTitle());
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Invalid unique code.");
        }
    }

    public void returnBook(String uniqueCode) {
        Book book = books.get(uniqueCode);
        if (book != null) {
            if (book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned: " + book.getTitle());
            } else {
                System.out.println("Book is not currently issued.");
            }
        } else {
            System.out.println("Invalid unique code.");
        }
    }

    private String generateUniqueCode() {
        return UUID.randomUUID().toString();
    }
}

class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Book Issue and Return System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter unique code: ");
                    String issueCode = scanner.nextLine();
                    library.issueBook(issueCode);
                    break;
                case 3:
                    System.out.print("Enter unique code: ");
                    String returnCode = scanner.nextLine();
                    library.returnBook(returnCode);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

