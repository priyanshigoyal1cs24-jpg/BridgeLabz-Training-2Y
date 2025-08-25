import java.util.Scanner;

public class VotingEligibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Check voting eligibility
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else if (age >= 0) {
            System.out.println("You are not eligible to vote. You must be at least 18 years old.");
        } else {
            System.out.println("Invalid age entered. Age cannot be negative.");
        }

        scanner.close();
    }
}
