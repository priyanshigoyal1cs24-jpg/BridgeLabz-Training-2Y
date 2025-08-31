import java.util.Scanner;

public class java10 {
    public double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }

    public String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] people = new double[10][3]; // weight, height, bmi
        String[] status = new String[10];

        BMI b = new BMI();
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            people[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            people[i][1] = sc.nextDouble();

            people[i][2] = b.calculateBMI(people[i][0], people[i][1]);
            status[i] = b.getStatus(people[i][2]);
        }

        System.out.println("\nWeight | Height | BMI | Status");
        for (int i = 0; i < 10; i++) {
            System.out.println(people[i][0] + " | " + people[i][1] + " | " +
                               String.format("%.2f", people[i][2]) + " | " + status[i]);
        }
    }
}
