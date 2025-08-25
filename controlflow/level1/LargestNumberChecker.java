import java.util.Scanner;

public class LargestNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get three numbers from the user
        System.out.print("Enter the first number: ");
        int first = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int second = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int third = scanner.nextInt();

        // Check which one is the largest
        if (first >= second && first >= third) {
            System.out.println("The first number is the largest.");
        } else if (second >= first && second >= third) {
            System.out.println("The second number is the largest.");
        } else {
            System.out.println("The third number is the largest.");
        }

        scanner.close();
    }
}
