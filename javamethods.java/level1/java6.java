import java.util.Scanner;

class java6 {
    public int sumOfN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        SumNaturalNumbers sn = new SumNaturalNumbers();
        System.out.println("Sum of first " + n + " natural numbers = " + sn.sumOfN(n));
    }
}
