import java.util.*;

class java11{
    public static double[][] generateData(int n) {
        double[][] data = new double[n][2]; // [salary, yearsOfService]
        for (int i = 0; i < n; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000; // 5-digit salary
            data[i][1] = (int)(Math.random() * 10) + 1;        // 1–10 years
        }
        return data;
    }

    public static double[][] calculateBonus(double[][] data) {
        double[][] result = new double[data.length][2]; // [newSalary, bonus]
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void display(double[][] data, double[][] result) {
        double sumOl
