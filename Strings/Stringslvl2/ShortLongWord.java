package first.Arraysandstrings.Strings.Stringslvl2;
import java.util.Scanner;

public class ShortLongWord {

    public static String[] splitText(String text){

        int words = 1;

        for(int i=0;i<text.length();i++)
            if(text.charAt(i) == ' ')
                words++;

        String[] arr = new String[words];

        int start = 0, index = 0;

        for(int i=0;i<text.length();i++){

            if(text.charAt(i) == ' '){
                arr[index++] = text.substring(start,i);
                start = i+1;
            }
        }

        arr[index] = text.substring(start);

        return arr;
    }

    public static int findLength(String text){

        int count = 0;

        try{
            while(true){
                text.charAt(count);
                count++;
            }
        }
        catch(Exception e){
            return count;
        }
    }

    public static int[] findShortLong(String[] words){

        int shortest = 0;
        int longest = 0;

        for(int i=1;i<words.length;i++){

            if(findLength(words[i]) < findLength(words[shortest]))
                shortest = i;

            if(findLength(words[i]) > findLength(words[longest]))
                longest = i;
        }

        return new int[]{shortest,longest};
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] words = splitText(text);

        int[] result = findShortLong(words);

        System.out.println("Shortest word: " + words[result[0]]);
        System.out.println("Longest word: " + words[result[1]]);
    }
}
