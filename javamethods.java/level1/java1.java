import java.util.Scanner;

class java1 {
    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time (years): ");
        double time = sc.nextDouble();

        SimpleInterestCalculator calc = new SimpleInterestCalculator();
        double si = calc.calculateSimpleInterest(principal, rate, time);

        System.out.println("The Simple Interest is " + si + 
            " for Principal " + principal + 
            ", Rate of Interest " + rate + 
            " and Time " + time);
    }
}
