import java.util.Scanner;

class pw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter base number: ");
        int number = input.nextInt();

        System.out.print("Enter power: ");
        int power = input.nextInt();

        long result = 1;
        int counter = 0;

        while (counter < power) {
            result *= number;
            counter++;
        }

        System.out.println(number + " raised to the power " + power + " = " + result);
        input.close();
    }
}
