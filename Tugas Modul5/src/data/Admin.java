package data;

import books.*;
import static com.main.Main.*;

import exception.custom.illegalAdminAccess;
import util.iMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements iMenu {
    Scanner scanner = new Scanner(System.in);

    public Admin() {
        super("admin");
    }

    public void login() {
        System.out.print("Masukkan Username (admin): ");
        String username = scanner.next();
        System.out.print("Masukkan Password (admin): ");
        String password = scanner.next();
        try {
            if (isAdmin(username, password)) {
                System.out.println("Login berhasil sebagai Admin");
                menu();
            } else {
                System.out.println("User Admin tidak ditemukan");
            }
        } catch (illegalAdminAccess e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isAdmin(String username, String password) throws illegalAdminAccess {
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("login berhasil");
        } else {
            throw new illegalAdminAccess("invalid credential");
        }
        return true;
    }

    public void menu() {
        try {
            while (true) {
                System.out.println("Dashboard Admin");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Tampilkan Mahasiswa");
                System.out.println("3. Input Buku");
                System.out.println("4. Tampilkan Daftar Buku");
                System.out.println("5. Logout");
                System.out.print("Pilih antara (1-5): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        inputBook();
                        break;
                    case 4:
                        displayBooks(daftarBuku);
                        break;
                    case 5:
                        System.out.println("Logout berhasil.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }





    @Override
    public void addStudent() {
        System.out.println("Menambahkan mahasiswa...");
        System.out.print("Masukkan Nama: ");
        scanner.nextLine();
        String name =scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.next();

        if (nim.length() != 15) {
            System.out.println("NIM tidak valid! Harus 15 karakter.");
            return;
        }
        scanner.nextLine();
        System.out.print("Masukkan Fakultas: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan Program Studi: ");
        String studyProgram = scanner.nextLine();
        studentList.add(new Student(nim, name, faculty, studyProgram));
        System.out.println("Mahasiswa dengan NIM " + nim + " berhasil ditambahkan.");
    }




    private void inputBook() {
        System.out.println("Memasukkan buku...");
        System.out.println("Pilih jenis buku:");
        System.out.println("1. History Book");
        System.out.println("2. Story Book");
        System.out.println("3. Text Book");
        System.out.print("Pilih jenis buku (1-3): ");
        int bookType = scanner.nextInt();
        scanner.nextLine();

        String idBuku, judul, author,category = new String();
        int stok;
        System.out.print("Masukkan judul buku: ");
        judul = scanner.nextLine();
        System.out.print("Masukkan author buku: ");
        author = scanner.nextLine();
        if (bookType == 1){
            category = "History";
        } else if (bookType == 2){
            category = "Story";
        } else if (bookType == 3){
            category = "Text";
        }
        System.out.print("Masukkan stok buku: ");
        stok = scanner.nextInt();
        scanner.nextLine();

        switch (bookType) {
            case 1:
                idBuku = generateId("HB");
                daftarBuku.add(new HistoryBook(idBuku, judul, stok, category, author)) ;
                break;
            case 2:
                idBuku = generateId("SB");
                daftarBuku.add(new HistoryBook(idBuku, judul, stok, category, author)) ;
                break;
            case 3:
                idBuku = generateId("TB");
                daftarBuku.add(new TextBook(idBuku, judul, stok, category, author)) ;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        System.out.println("Buku berhasil ditambahkan.");
    }

    @Override
    public void displayBooks(ArrayList<Book> bookArrayList) {
        System.out.println("Daftar Buku Tersedia:");
        System.out.println("==============================================================================");
        System.out.println("|\tNo.\t|\tId Buku\t|\tNama Buku\t|\tAuthor\t|\tCategory\t|\tStock\t|");
        int index = 1;
        for (Book book : daftarBuku) {
            if (book != null) {
                System.out.println("|\t" + index + "\t||\t" + book.getIdBuku() + "\t|\t" + book.getJudul() + "\t\t\t|\t" + book.getAuthor() + "\t\t|\t" + book.getCategory() + "\t\t||\t" + book.getStok() + "\t\t||\t");
                System.out.println("==============================================================================");
                index ++;
            }
        }
    }

    private void displayStudents() {
        System.out.println("Daftar Mahasiswa yang terdaftar:");
        for (Student student : studentList) {
            System.out.println("\nNama: " + student.getName());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Fakultas: " + student.getFaculty());
            System.out.println("Program Studi: " + student.getStudyProgram());
            if (!student.getBorrowedBooks().isEmpty()) {
                System.out.println("  Meminjam Buku:");
                for (Book book : student.getBorrowedBooks()) {
                    System.out.println("    - " + book.getJudul());
                }
            }
        }
    }

    private String generateId(String prefix) {
        int nextId = i + 1;
        return prefix + String.format("%03d", nextId);
    }
}