import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int findLongestSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        // Add all elements to the set
        for (int num : arr) set.add(num);
        
        int longestStreak = 0;
        
        for (int num : set) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                // Count consecutive sequence
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + findLongestSequence(arr));
    }
}
