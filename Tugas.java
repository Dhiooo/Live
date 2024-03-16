import java.util.ArrayList;
import java.util.Scanner;

public class Tugas {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Menambahkan buku ke dalam daftar buku
        books.add(new Book("401e-291a-9912", "Elden Ring", "Hideo", "Adventure", 2));
        books.add(new Book("31zi-ns24-201b", "Apex", "Respawn.E", "War", 1));
        books.add(new Book("001k-091s-194q", "Fifa", "EA", "Soccer", 4));

        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as an Student");
            System.out.println("2. Login as an Admin");
            System.out.println("3. Exit");
            System.out.print("Choose menu from (1-3): ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    loginAsStudent();
                    break;
                case 2:
                    loginAsAdmin();
                    break;
                case 3:
                    System.out.println("Thank you, exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Non valid input.");
            }
        }
    }
    public static void loginAsStudent() {
        System.out.println("===== Student Menu ====");
        System.out.print("Enter your student id (Type 60 to return back): ");
        String nim = scanner.next();

        if (nim.equals("60")) {
            System.out.println("Returning back...");
            return;
        }

        Student student = findStudentByNim(nim);

        if (student == null) {
            System.out.println("Student id not found. returning to Home");
            return;
        }

        while (true) {
            System.out.println("\n===== Student Menu ====");
            System.out.println("1. Book is borrowed");
            System.out.println("2. Borrowing books");
            System.out.println("3. Exit");
            System.out.print("Choose from (1-3): ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    student.viewBorrowedBooks();
                    break;
                case 2:
                    student.borrowBook(books, scanner);
                    break;
                case 3:
                    System.out.println("Log out from student account...");
                    return;
                default:
                    System.out.println("Non valid, let's try again.");
            }
        }
    }
    public static Student findStudentByNim(String nim) {
        for (Student s : students) {
            if (s.getNim().equals(nim)) {
                return s;
            }
        }
        return null;
    }
    public static void loginAsAdmin() {
        System.out.println("===== Admin Menu =====");
        System.out.println("1. Add student");
        System.out.println("2. Display the student list");
        System.out.println("3. Exit");
        System.out.print("Choose from (1-3): ");
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                addStudent();
                break;
            case 2:
                displayRegisteredStudents();
                break;
            case 3:
                System.out.println("Log out from admin account");
                break;
            default:
                System.out.println("Non valid input, let's try again.");
        }
    }
    public static void addStudent() {
        System.out.print("Enter the student name: ");
        String name = scanner.next();
        System.out.print("Enter the student faculty: ");
        String faculty = scanner.next();
        System.out.print("Enter the student ID: ");
        String nim = scanner.next();
        System.out.print("Enter the student major: ");
        String program = scanner.next();

        students.add(new Student(name, faculty, nim, program));
        System.out.println("Student has succesfully added to the program");
    }
    public static void displayRegisteredStudents() {
        System.out.println("\n===== Added student =====");
        System.out.printf("%-20s %-20s %-15s %-20s\n", "Name", "Faculty", "ID", "Major");
        for (Student student : students) {
            System.out.printf("%-20s %-20s %-15s %-20s\n", student.getName(), student.getFaculty(), student.getNim(), student.getProgram());
        }
    }
}
class Student {
    private String name;
    private String faculty;
    private String nim;
    private String program;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    public Student(String name, String faculty, String nim, String program) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.program = program;
    }
    public String getName() {
        return name;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getNim() {
        return nim;
    }
    public String getProgram() {
        return program;
    }
    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You are not borrowing any books yet.");
            return;
        }
        System.out.println("\n===== Books borrowed by you =====");
        System.out.printf("%-10s %-20s %-20s %-10s\n", "ID", "Title", "Writer", "Stock");
        for (Book book : borrowedBooks) {
            System.out.printf("%-10s %-20s %-20s %-10d\n", book.getId(), book.getTitle(), book.getAuthor(), book.getStock());
        }
    }
    public void borrowBook(ArrayList<Book> books, Scanner scanner) {
        System.out.print("Enter the book id that you want to borrow: ");
        String id = scanner.next();

        if (id.isEmpty()) {
            System.out.println("You can't borrow any book without entering the ID. Returning to home");
            return;
        }

        Book book = null;
        for (Book b : books) {
            if (b.getId().equals(id)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found. Returning to Home");
            return;
        }

        if (book.getStock() > 0) {
            borrowedBooks.add(book);
            book.setStock(book.getStock() - 1);
            System.out.println("Book has succesfully borrowed");
        } else {
            System.out.println("Book is out of stock.");
        }
    }
}
class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int stock;
    public Book(String id, String title, String author, String category, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}