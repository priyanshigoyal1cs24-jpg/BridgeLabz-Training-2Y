import java.util.Scanner;

class java3 {
    public double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter; // 5 km = 5000 m
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double a = sc.nextDouble();
        System.out.print("Enter side2: ");
        double b = sc.nextDouble();
        System.out.print("Enter side3: ");
        double c = sc.nextDouble();

        TriangularParkRun run = new TriangularParkRun();
        System.out.println("Rounds needed: " + run.calculateRounds(a, b, c));
    }
}
