import java.util.Scanner;

public class RocketLaunchCountdown1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the starting countdown number
        System.out.print("Enter the starting countdown number: ");
        int start = scanner.nextInt();

        // Check if the input is valid
        if (start < 1) {
            System.out.println("Please enter a number greater than or equal to 1.");
        } else {
            // Countdown using for loop
            for (int i = start; i >= 1; i--) {
                System.out.println(i + "...");
                try {
                    Thread.sleep(1000); // Pause for 1 second (optional)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupt status
                }
            }

            System.out.println("🚀 Launch!");
        }

        scanner.close();
    }
}
