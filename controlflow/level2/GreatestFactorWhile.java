import java.util.Scanner;

class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int greatestFactor = 1;
        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }

        System.out.println("Greatest factor (besides itself) of " + number + " is: " + greatestFactor);
        input.close();
    }
}
