import java.util.Scanner;

class ageheight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input ages and heights
        System.out.print("Enter Amar's age and height: ");
        int ageAmar = input.nextInt();
        int heightAmar = input.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int ageAkbar = input.nextInt();
        int heightAkbar = input.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int ageAnthony = input.nextInt();
        int heightAnthony = input.nextInt();

        // Youngest
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Youngest: Amar");
        } else if (ageAkbar < ageAnthony) {
            System.out.println("Youngest: Akbar");
        } else {
            System.out.println("Youngest: Anthony");
        }

        // Tallest
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Tallest: Amar");
        } else if (heightAkbar > heightAnthony) {
            System.out.println("Tallest: Akbar");
        } else {
            System.out.println("Tallest: Anthony");
        }

        input.close();
    }
}
