import java.util.Scanner;

public class java9 {
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) { return a / b; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose operation: +, -, *, /");
        char op = sc.next().charAt(0);

        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble(), b = sc.nextDouble();

        switch (op) {
            case '+': System.out.println("Result: " + add(a, b)); break;
            case '-': System.out.println("Result: " + subtract(a, b)); break;
            case '*': System.out.println("Result: " + multiply(a, b)); break;
            case '/': 
                if (b != 0) System.out.println("Result: " + divide(a, b));
                else System.out.println("Error: Division by zero!");
                break;
            default: System.out.println("Invalid operation!");
        }
    }
}
