import java.util.Scanner;

public class SumUntilZeroOrNegative {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter positive numbers to add (enter 0 or a negative number to stop):");

        while (true) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                break; // Exit the loop if number is 0 or negative
            }

            sum += number;
        }

        System.out.println("The total sum is: " + sum);

        scanner.close();
    }
}
