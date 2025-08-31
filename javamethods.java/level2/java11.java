import java.util.Scanner;

public class java11 {
    public double[] findRoots(double a, double b, double c) {
        double delta = (b * b) - (4 * a * c);
        if (delta < 0) return new double[]{}; // no real roots
        if (delta == 0) return new double[]{-b / (2 * a)};
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[]{root1, root2};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        Quadratic q = new Quadratic();
        double[] roots = q.findRoots(a, b, c);

        if (roots.length == 0) System.out.println("No Real Roots");
        else {
            for (int i = 0; i < roots.length; i++) {
                System.out.println("Root " + (i + 1) + " = " + roots[i]);
            }
        }
    }
}
