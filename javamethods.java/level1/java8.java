import java.util.Scanner;

class java8 {
    public int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.print("Enter divisor: ");
        int div = sc.nextInt();

        QuotientRemainder qr = new QuotientRemainder();
        int[] result = qr.findRemainderAndQuotient(num, div);
        System.out.println("Quotient: " + result[0] + ", Remainder: " + result[1]);
    }
}
