package javastart.com.testtask;

import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {

                System.out.println("Input: ");
                String line = scanner.nextLine();

                if (line.equals("q")) {

                    break;
                }
                System.out.println("Output:" + calculator.getResult(line));

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                break;
            }

        }

        scanner.close();

    }
}
