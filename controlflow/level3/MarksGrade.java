import java.util.Scanner;

class MarksGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        int physics = input.nextInt();

        System.out.print("Enter Chemistry marks: ");
        int chemistry = input.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = input.nextInt();

        double percentage = (physics + chemistry + maths) / 3.0;
        System.out.println("Average Percentage: " + percentage);

        if (percentage >= 90) {
            System.out.println("Grade: A+ (Excellent)");
        } else if (percentage >= 75) {
            System.out.println("Grade: A (Very Good)");
        } else if (percentage >= 60) {
            System.out.println("Grade: B (Good)");
        } else if (percentage >= 40) {
            System.out.println("Grade: C (Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
        }

        input.close();
    }
}
