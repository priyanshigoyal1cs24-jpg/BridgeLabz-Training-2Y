import java.util.Scanner;

class java9 {
    public int[] distributeChocolates(int chocolates, int children) {
        int eachGets = chocolates / children;
        int remaining = chocolates % children;
        return new int[]{eachGets, remaining};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total chocolates: ");
        int chocolates = sc.nextInt();
        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        ChocolateDistribution cd = new ChocolateDistribution();
        int[] result = cd.distributeChocolates(chocolates, children);
        System.out.println("Each child gets: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
