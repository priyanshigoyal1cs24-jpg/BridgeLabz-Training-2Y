import java.util.Random;
import java.util.Scanner;

public class java1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int low = 1, high = 100, guess;
        String feedback;

        System.out.println("Think of a number between 1 and 100.");
        do {
            guess = rand.nextInt(high - low + 1) + low;
            System.out.println("Computer guesses: " + guess);
            System.out.print("Is it high, low, or correct? ");
            feedback = sc.next().toLowerCase();

            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        } while (!feedback.equals("correct"));

        System.out.println("Yay! Computer guessed your number.");
    }
}
