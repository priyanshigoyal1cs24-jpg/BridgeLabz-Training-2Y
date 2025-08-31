import java.util.*;

class java8{
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; // 6-digit
    }

    public static boolean areUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int val : arr) {
            if (!set.add(val)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        System.out.println("All OTPs unique? " + areUnique(otps));
    }
}
