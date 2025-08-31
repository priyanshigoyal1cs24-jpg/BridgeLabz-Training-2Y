import java.util.Scanner;

class java10 {
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + (0.6215 * temperature) + 
               (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (°F): ");
        double temp = sc.nextDouble();
        System.out.print("Enter wind speed (mph): ");
        double windSpeed = sc.nextDouble();

        WindChill wc = new WindChill();
        System.out.println("Wind Chill Temperature = " + wc.calculateWindChill(temp, windSpeed));
    }
}
