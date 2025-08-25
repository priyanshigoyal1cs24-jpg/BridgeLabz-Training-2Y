import java.util.Scanner;

public class EmployeeBonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of years of service: ");
        int years = scanner.nextInt();

        int bonus = 0;

        if (years < 1) {
            bonus = 0;
        } else if (years <= 3) {
            bonus = 500;
        } else if (years <= 6) {
            bonus = 1000;
        } else {
            bonus = 1500;
        }

        System.out.println("The bonus for " + years + " years of service is: $" + bonus);

        scanner.close();
    }
}
