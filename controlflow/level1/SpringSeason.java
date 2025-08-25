public class SpringSeason {

    public static void main(String[] args) {
        // Check if exactly 2 arguments are passed
        if (args.length != 2) {
            System.out.println("Please provide exactly two integer arguments: month and day.");
            return;
        }

        // Parse command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        boolean isSpring = false;

        // Check for valid Spring Season date range: March 20 to June 20
        if ((month == 3 && day >= 20 && day <= 31) ||
            (month == 4 && day >= 1 && day <= 30) ||
            (month == 5 && day >= 1 && day <= 31) ||
            (month == 6 && day >= 1 && day <= 20)) {
            isSpring = true;
        }

        if (isSpring) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
