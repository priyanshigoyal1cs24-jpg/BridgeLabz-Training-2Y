package first.Arraysandstrings.Strings.Stringslvl2;
import java.util.Scanner;

public class SplitTextProgram {

    public static String[] splitText(String text) {

        int words = 1;

        for(int i=0;i<text.length();i++){
            if(text.charAt(i) == ' ')
                words++;
        }

        String[] result = new String[words];

        int start = 0;
        int index = 0;

        for(int i=0;i<text.length();i++){

            if(text.charAt(i) == ' '){
                result[index++] = text.substring(start,i);
                start = i+1;
            }
        }

        result[index] = text.substring(start);

        return result;
    }

    public static boolean compareArrays(String[] a, String[] b){

        if(a.length != b.length)
            return false;

        for(int i=0;i<a.length;i++){
            if(!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] userWords = splitText(text);
        String[] builtinWords = text.split(" ");

        boolean result = compareArrays(userWords, builtinWords);

        System.out.println("Arrays equal: " + result);
    }
}
