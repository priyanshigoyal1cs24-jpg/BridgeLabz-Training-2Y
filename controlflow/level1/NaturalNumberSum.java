import java.util.Scanner;

public class NaturalNumberSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        // Check if it's a natural number
        if (n <= 0) {
            System.out.println("The number is not a natural number. Please enter a positive integer (n >= 1).");
        } else {
            // Calculate the sum using formula: sum = n * (n + 1) / 2
            int sum = n * (n + 1) / 2;
            System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }
}
