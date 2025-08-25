import java.util.Scanner;

class bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get salary and years of service
        System.out.print("Enter your salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int years = input.nextInt();

        double bonus = 0;
        if (years > 5) {
            bonus = salary * 0.05;
        }

        System.out.println("Bonus amount: " + bonus);
        input.close();
    }
}
