import java.util.Scanner;

public class SumNaturalNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number (n >= 1): ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a natural number (1 or greater).");
        } else {
            int sum = 0;
            int i = 1;

            while (i <= n) {
                sum += i;
                i++;
            }

            int formulaSum = n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sum);
            System.out.println("Sum using formula   : " + formulaSum);

            if (sum == formulaSum) {
                System.out.println("Both results are correct!");
            } else {
                System.out.println("There is a mismatch in the results.");
            }
        }

        scanner.close();
    }
}
