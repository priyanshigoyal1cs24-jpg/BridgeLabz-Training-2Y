import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class SlidingWindowMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;
        
        // Deque stores indices
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            
            // Remove indices of smaller elements as they are useless
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            // Add current element's index
            dq.offerLast(i);
            
            // Wait until our window reaches size k before adding to result
            if (i >= k - 1) {
                result[resIndex++] = nums[dq.peekFirst()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Max sliding window: " + Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
