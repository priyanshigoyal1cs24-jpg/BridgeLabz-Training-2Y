import java.util.Scanner;

public class java7 {
    public boolean canStudentVote(int age) {
        if (age < 0) return false; // invalid
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        StudentVoteChecker svc = new StudentVoteChecker();

        for (int i = 0; i < 10; i++) {
            System.out.print
