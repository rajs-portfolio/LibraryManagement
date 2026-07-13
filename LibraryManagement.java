import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    books.add(new Book(title, author));
                    System.out.println("Book Added Successfully!");
                    break;

                case 2:

                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {

                        System.out.println("\nBooks:");

                        for (Book b : books) {
                            System.out.println("Title : " + b.title);
                            System.out.println("Author: " + b.author);
                            System.out.println("---------------------");
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Book Title: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (Book b : books) {

                        if (b.title.equalsIgnoreCase(search)) {

                            System.out.println("\nBook Found!");
                            System.out.println("Title : " + b.title);
                            System.out.println("Author: " + b.author);

                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Book not found.");

                    break;

                case 4:

                    System.out.print("Enter Book Title: ");
                    String remove = sc.nextLine();

                    boolean deleted = books.removeIf(
                            b -> b.title.equalsIgnoreCase(remove));

                    if (deleted)
                        System.out.println("Book Removed!");
                    else
                        System.out.println("Book not found.");

                    break;

                case 5:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}