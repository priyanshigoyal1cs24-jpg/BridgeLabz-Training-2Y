import java.util.Scanner;

class java2 {
    public int calculateHandshakes(int students) {
        return (students * (students - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Handshakes h = new Handshakes();
        System.out.println("Maximum handshakes: " + h.calculateHandshakes(n));
    }
}
