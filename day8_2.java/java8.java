import java.util.Scanner;

public class java8 {
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.print("Is this in (C)elsius or (F)ahrenheit? ");
        char unit = sc.next().toUpperCase().charAt(0);

        if (unit == 'C') {
            System.out.println("In Fahrenheit: " + celsiusToFahrenheit(temp));
        } else {
            System.out.println("In Celsius: " + fahrenheitToCelsius(temp));
        }
    }
}
