package com.main;
import books.*;
import data.User;
import data.Admin;
import data.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static ArrayList <Book> daftarBuku = new ArrayList<>();
    public static ArrayList <Student> studentList = new ArrayList<>();
    public static int i = 0;

    public static void main(String[] args) {

        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("Library System Login");
                System.out.println("1. Login sebagai Mahasiswa");
                System.out.println("2. Login sebagai Admin");
                System.out.println("3. Keluar");
                System.out.print("Pilih antara (1-3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan NIM : ");
                        String nimStudent = scanner.next();
                        if (nimStudent.length() != 15) {
                            System.out.println("NIM tidak valid!");
                            break;
                        }
                        Student student = new Student(nimStudent);
                        student.login();
                        break;
                    case 2:
                        Admin admin = new Admin();
                        admin.login();
                        break;
                    case 3:
                        System.out.println("Terima kasih");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}





