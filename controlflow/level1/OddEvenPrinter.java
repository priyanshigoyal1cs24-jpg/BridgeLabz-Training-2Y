import java.util.Scanner;

public class OddEvenPrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (greater than or equal to 1): ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a number greater than or equal to 1.");
        } else {
            System.out.println("Even numbers between 1 and " + n + ":");
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }

            System.out.println("\nOdd numbers between 1 and " + n + ":");
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
        }

        scanner.close();
    }
}

