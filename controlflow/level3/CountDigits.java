import java.util.Scanner;

class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = 0;
        int temp = Math.abs(number); // handle negative numbers too

        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp /= 10;
                count++;
            }
        }

        System.out.println("Number of digits: " + count);
        input.close();
    }
}
