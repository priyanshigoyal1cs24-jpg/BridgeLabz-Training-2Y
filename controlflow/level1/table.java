import java.util.Scanner;

public class table {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to print its multiplication table from 6 to 9: ");
        int number = scanner.nextInt();

        System.out.println("Multiplication table of " + number + " from 6 to 9:");

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}
