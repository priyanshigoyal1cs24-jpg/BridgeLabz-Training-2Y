import java.time.LocalDate;

public class java2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 9, 1); // example input

        LocalDate result = date.plusDays(7)
                               .plusMonths(1)
                               .plusYears(2)
                               .minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("Modified Date: " + result);
    }
}
