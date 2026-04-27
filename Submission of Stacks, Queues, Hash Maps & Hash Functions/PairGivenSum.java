import java.util.HashSet;

public class PairGivenSum {

    public static boolean hasPair(int[] arr, int targetSum) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(targetSum - num)) {
                System.out.println("Pair found: (" + (targetSum - num) + ", " + num + ")");
                return true;
            }
            seen.add(num);
        }
        
        System.out.println("No pair found for target: " + targetSum);
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int targetSum = 10;
        hasPair(arr, targetSum);
    }
}
