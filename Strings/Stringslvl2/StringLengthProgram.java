package first.Arraysandstrings.Strings.Stringslvl2;
import java.util.Scanner;

public class StringLengthProgram {

    public static int findLength(String text) {

        int count = 0;

        try {
            while(true) {
                text.charAt(count);
                count++;
            }
        }
        catch(Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        int userLength = findLength(text);
        int builtinLength = text.length();

        System.out.println("Length using charAt(): " + userLength);
        System.out.println("Length using length(): " + builtinLength);
    }
}