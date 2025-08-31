import java.util.Scanner;

class java5 {
    public boolean isSpringSeason(int month, int day) {
        // Spring is March 20 to June 20
        if ((month == 3 && day >= 20) || 
            (month == 4) || 
            (month == 5) || 
            (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.
