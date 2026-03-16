package first.Arraysandstrings.Strings.Stringslvl1;
import java.util.Scanner;

public class StringIndexException {

    public static void generateException(String text){

        System.out.println(text.charAt(text.length()+2));
    }

    public static void handleException(String text){

        try{

            System.out.println(text.charAt(text.length()+2));

        }catch(StringIndexOutOfBoundsException e){

            System.out.println("Exception handled: " + e);
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        // generateException(text); // will crash

        handleException(text);
    }
}
