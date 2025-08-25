import java.util.Scanner;

public class SumUntilZero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum = 0;

        System.out.println("Enter numbers to add to the sum (enter 0 to stop):");

        // Keep reading numbers until the user enters 0
        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            sum += number;
        } while (number != 0);

        System.out.println("The total sum is: " + sum);

        scanner.close();
    }
}
