import java.util.Scanner;

class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check for natural number
        if (number <= 0) {
            System.out.println("Please enter a positive natural number.");
        } else {
            // Loop through 1 to number
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is Even");
                } else {
                    System.out.println(i + " is Odd");
                }
            }
        }
        input.close();
    }
}
