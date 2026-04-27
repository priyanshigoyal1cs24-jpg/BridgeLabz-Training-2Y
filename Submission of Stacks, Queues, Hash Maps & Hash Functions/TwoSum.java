import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        // Map stores actual numbers as keys and their array indices as values
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the pair match exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Save the number and its index
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}
