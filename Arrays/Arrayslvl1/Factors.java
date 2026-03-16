package first.Arraysandstrings.Arrays.Arrayslvl1;
import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int max = 10;
        int[] factors = new int[max];
        int index = 0;

        for(int i=1;i<=num;i++){

            if(num % i == 0){

                if(index == max){

                    max = max * 2;
                    int[] temp = new int[max];

                    for(int j=0;j<index;j++)
                        temp[j] = factors[j];

                    factors = temp;
                }

                factors[index++] = i;
            }
        }

        System.out.println("Factors:");

        for(int i=0;i<index;i++)
            System.out.print(factors[i]+" ");
    }
}
