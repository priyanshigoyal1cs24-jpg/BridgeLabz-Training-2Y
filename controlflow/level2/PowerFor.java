import java.util.Scanner;

class PowerFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter base number: ");
        int number = input.nextInt();

        System.out.print("Enter power: ");
        int power = input.nextInt();

        long result = 1;

        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(number + " raised to the power " + power + " = " + result);
        input.close();
    }
}
