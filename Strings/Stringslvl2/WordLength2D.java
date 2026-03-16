package first.Arraysandstrings.Strings.Stringslvl2;
import java.util.Scanner;

public class WordLength2D {

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

    public static String[][] wordLength(String[] words){

        String[][] result = new String[words.length][2];

        for(int i=0;i<words.length;i++){

            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] table = wordLength(words);

        System.out.println("Word\tLength");

        for(int i=0;i<table.length;i++){
            int len = Integer.parseInt(table[i][1]);
            System.out.println(table[i][0] + "\t" + len);
        }
    }
}
