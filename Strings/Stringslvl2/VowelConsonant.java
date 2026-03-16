package first.Arraysandstrings.Strings.Stringslvl2;
import java.util.Scanner;

public class VowelConsonant {

    public static String checkChar(char ch){

        if(ch >= 'A' && ch <= 'Z')
            ch = (char)(ch + 32);

        if(ch >= 'a' && ch <= 'z'){

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                return "Vowel";
            else
                return "Consonant";
        }

        return "NotLetter";
    }

    public static int[] countVC(String text){

        int vowel = 0;
        int consonant = 0;

        for(int i=0;i<text.length();i++){

            String result = checkChar(text.charAt(i));

            if(result.equals("Vowel"))
                vowel++;
            else if(result.equals("Consonant"))
                consonant++;
        }

        return new int[]{vowel,consonant};
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] result = countVC(text);

        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }
}