public class java12 {
    public int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000;
        }
        return arr;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double avg = (double) sum / numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        RandomStats rs = new RandomStats();
        int[] arr = rs.generate4DigitRandomArray(5);

        System.out.print("Numbers: ");
        for (int num : arr) System.out.print(num + " ");

        double[] stats = rs.findAverageMinMax(arr);
        System.out.println("\nAverage = " + stats[0]);
        System.out.println("Minimum = " + stats[1]);
        System.out.println("Maximum = " + stats[2]);
    }
