import java.util.Scanner;

public class RocketLaunchCountdown {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the starting countdown number
        System.out.print("Enter the starting countdown number: ");
        int count = scanner.nextInt();

        // Check if the input is valid (must be positive)
        if (count < 1) {
            System.out.println("Please enter a number greater than or equal to 1.");
        } else {
            // Countdown using while loop
            while (count >= 1) {
                System.out.println(count + "...");
                try {
                    Thread.sleep(1000); // Optional: wait for 1 second between numbers
                } catch (InterruptedException e) {
                    // Handle exception if sleep is interrupted
                    Thread.currentThread().interrupt();
                }
                count--;
            }

            System.out.println("🚀 Launch!");
        }

        scanner.close();
    }
}
