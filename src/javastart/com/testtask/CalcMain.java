package javastart.com.testtask;

import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input: ");
            String line = scanner.nextLine();
            System.out.println("равно"+line);
            if (line.equals("q")) {

                break;
            }
        }
        scanner.close();

    }
}
