import java.util.Scanner;

public class java9 {
    public boolean isPositive(int num) {
        return num >= 0;
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        NumberAnalysis na = new NumberAnalysis();

        for (int num : arr) {
            if (na.isPositive(num)) {
                System.out.print(num + " is Positive, ");
                if (na.isEven(num)) System.out.println("Even");
                else System.out.println("Odd");
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int cmp = na.compare(arr[0], arr[arr.length - 1]);
        if (cmp == 0) System.out.println("First and Last elements are Equal");
        else if (cmp == 1) System.out.println("First element is Greater");
        else System.out.println("First element is Smaller");
    }
}
