class java2 {
    public static int[] getDigits(int number) {
        String s = Integer.toString(number);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static boolean isDuck(int[] digits) {
        for (int d : digits) if (d == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, n);
        int original = 0;
        for (int d : digits) original = original * 10 + d;
        return sum == original;
    }

    public static int[] findLargestTwo(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }

    public static int[] findSmallestTwo(int[] digits) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < first) {
                second = first;
                first = d;
            } else if (d < second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigits(number);
        System.out.println("Duck Number? " + isDuck(digits));
        System.out.println("Armstrong Number? " + isArmstrong(digits));
        int[] largest = findLargestTwo(digits);
        int[] smallest = findSmallestTwo(digits);
        System.out.println("Largest = " + largest[0] + ", Second Largest = " + largest[1]);
        System.out.println("Smallest = " + smallest[0] + ", Second Smallest = " + smallest[1]);
    }
}
