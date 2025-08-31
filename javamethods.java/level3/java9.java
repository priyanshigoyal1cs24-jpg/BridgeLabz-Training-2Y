import java.util.*;

class java9 {
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDay(int month, int year) {
        // Zeller's Congruence
        if (month < 3) { month += 12; year--; }
        int k = year % 100, j = year / 100;
        int h = (1 + (13*(month+1))/5 + k + k/4 + j/4 + (5*j)) % 7;
        return (h + 6) % 7; // 0 = Sunday
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        int daysInMonth = days[month-1];
        if (month == 2 && isLeapYear(year)) daysInMonth = 29;

        int firstDay = getFirstDay(month, year);

        System.out.println("\n  " + months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) System.out.println();
        }
    }
}
