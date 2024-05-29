import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> namaMahasiswa = new ArrayList<>();

        int i = 1;
        while (namaMahasiswa.size() < 5) {
            try {
                System.out.print("Enter the name you want to " + i);
                String nama = scanner.nextLine();

                if (nama.equalsIgnoreCase("Done")) {
                    break;
                }

                if (nama.isEmpty()) {
                    throw new IllegalArgumentException("Can't let the name empty...please input the correct command!");
                }

                namaMahasiswa.add(nama);
                i++;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                scanner.next();
                System.err.println("Null. Enter the right name :(!");
            }
        }

        System.out.println("\nAll the list of an name you've just input:");
        for (String nama : namaMahasiswa) {
            System.out.println("  - " + nama);
        }
    }
}