import java.util.HashSet;

public class Assignment3 {
    
    // O(n * m) space efficient
    public static boolean implALoop(int[] completedCourses, int[] prerequisites) {
        for (int p : prerequisites) {
            boolean found = false;
            for (int c : completedCourses) {
                if (p == c) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
    
    // O(n + m) time efficient
    public static boolean implBHashSet(int[] completedCourses, int[] prerequisites) {
        HashSet<Integer> set = new HashSet<>();
        for (int c : completedCourses) {
            set.add(c);
        }
        for (int p : prerequisites) {
            if (!set.contains(p)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Space Complexity & Space-Time Tradeoffs ===");
        
        System.out.println("\na) Time Complexity:");
        System.out.println("Implementation A (Nested Loops): O(n * m)");
        System.out.println("Implementation B (Hash Set): O(n + m)");

        System.out.println("\nb) Auxiliary Space Complexity:");
        System.out.println("Implementation A: O(1) - Only iterative pointer variables used.");
        System.out.println("Implementation B: O(n) - Storage of independent Hash Set matching number of completed courses.");
        
        System.out.println("\nc) Scale constraints calculations:");
        int n = 40; // completed
        int m = 5;  // reqs
        System.out.println("Total Comparisons/day (Impl A): 40 * 5 * 100,000 = 20,000,000 operations");
        System.out.println("Total Memory Usage (Impl B): 40 entries * 8 bytes = 320 Bytes per concurrent request.");

        System.out.println("\nd) Architecture Decision:");
        System.out.println("Both satisfy constraints (<10ms, <1GB). Impl B uses ~3.2MB for 10k max conc requests, which is tiny.");
        System.out.println("Impl A uses zero memory overhead, running 200 ops * 0.1ms = 0.02ms (well under 10ms threshold). Both perform beautifully.");
        
        System.out.println("\ne) Hybrid Approach:");
        System.out.println("Threshold crossover: Switch from nested loop (Impl A) to HashSet (Impl B) when m > 5, because allocation overhead of hashing surpasses low-count direct array matching efficiency locally.");
    }
}
