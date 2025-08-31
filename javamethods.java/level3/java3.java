class java3 {
    public static int[] getDigits(int number) {
        String s = Integer.toString(number);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static int sumSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        return number % sumDigits(digits) == 0;
    }

    public static int[][] frequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int number = 132;
        int[] digits = getDigits(number);
        System.out.println("Sum of digits = " + sumDigits(digits));
        System.out.println("Sum of squares = " + sumSquares(digits));
        System.out.println("Harshad? " + isHarshad(number, digits));
        int[][] freq = frequency(digits);
        System.out.println("Digit Frequencies:");
        for (int[] f : freq) {
            if (f[1] > 0) System.out.println(f[0] + " → " + f[1]);
        }
    }
}
