import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraysZeroSum {
    
    // Class to represent an index pair
    static class Pair {
        int start, end;
        Pair(int s, int e) { start = s; end = e; }
        
        @Override
        public String toString() {
            return "[" + start + "..." + end + "]";
        }
    }
    
    public static List<Pair> findSubarrays(int[] arr) {
        List<Pair> results = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // Base case for subarrays starting at index 0
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);
        
        int prefixSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            // If prefixSum is found, it means subarrays exist
            if (map.containsKey(prefixSum)) {
                List<Integer> list = map.get(prefixSum);
                for (int p : list) {
                    results.add(new Pair(p + 1, i));
                }
            }
            
            // Store the current prefix sum index
            List<Integer> list = map.getOrDefault(prefixSum, new ArrayList<>());
            list.add(i);
            map.put(prefixSum, list);
        }
        
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<Pair> res = findSubarrays(arr);
        System.out.println("Subarrays with zero sum found at indices: " + res);
    }
}
