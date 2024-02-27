import java.util.Scanner;

public class Main {

    //Konstanta untuk menyimpan username, password dan NIM mahasiswa
    private static final String ADMIN_USERNAME = "Admin";
    private static final String ADMIN_PASSWORD = "Addmin";
    private static final String[] MAHASISWA_NIM = {"202310370311197"};

    public static void main(String[] args) {
        //Scanner untuk membaca input dari user lewat konsol
        Scanner scanner = new Scanner(System.in);


        //output awal yang akan ditampilkan untuk user
        System.out.println("Welcome to the UMM Library System");2
        System.out.println("Who are you again??:");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.println("3. Exit");
        System.out.print("Enter your choice from 1-3: ");

        //Membaca pilihan yang user input
        int choice = scanner.nextInt();
        scanner.nextLine();


        //Mengeksekusi program yang berdasarkan dari pilihan user
        switch (choice) {
            case 1:
                adminLogin(scanner);
                break;
            case 2:
                mahasiswaLogin(scanner);
                break;
            case 3:
                System.out.println("Goodbye, have a nice day!");
                break;
            default:
                System.out.println("Invalid command ");
        }

        scanner.close();
    }


    //proses login sebagai admmin
    private static void adminLogin(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

       //if else yang digunakan untuk memeriksa apakah username/pass nya benar
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Login as admin has succeeded, welcome Dhio.");

        } else {
            System.out.println("Sorry, wrong username or password.");
        }
    }


    //login sebagai mahasiswa
    private static void mahasiswaLogin(Scanner scanner) {
        System.out.print("Enter your student ID: ");
        String nim = scanner.nextLine();

        //memeriksa apakah NIM mahasiswa nya valid
        boolean nimFound = false;
        for (String validNIM : MAHASISWA_NIM) {
            if (nim.equals(validNIM)) {
                nimFound = true;
                break;
            }
        }

        if (nimFound) {
            System.out.println("Login as a student has succeeded, Welcome Dhio.");

        } else {
            System.out.println("Student ID not found.");
        }
    }
}


