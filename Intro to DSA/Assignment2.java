import java.util.HashSet;

public class Assignment2 {
    
    // Algorithm A: Linear Search O(n)
    public static boolean linearSearch(String[] userList, String target) {
        for (String user : userList) {
            if (user.equals(target)) return true;
        }
        return false;
    }
    
    // Algorithm B: Binary Search O(log n)
    public static boolean binarySearch(String[] sortedUserList, String target) {
        int left = 0, right = sortedUserList.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedUserList[mid].compareTo(target);
            if (cmp == 0) return true;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    
    // Algorithm C: Hash Table O(1)
    public static boolean hashSearch(HashSet<String> hashTable, String target) {
        return hashTable.contains(target);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Time Complexity Analysis ===");
        
        System.out.println("\na) Number of operations for worst case finding username in 10,000,000 users:");
        System.out.println("Algorithm A (Linear): 10,000,000 comparisons");
        System.out.println("Algorithm B (Binary): log2(10,000,000) ~ 24 comparisons");
        System.out.println("Algorithm C (Hash): ~1 operation (average case)");
        
        System.out.println("\nb) Big-O Notation:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
        System.out.println("Hash Table: O(1)");
        
        System.out.println("\nd) Load handling for 50,000 usernames/sec @ 1ns per check:");
        System.out.println("Alg A: 10,000,000 ns per run = 0.01 sec. 50k runs = 500 seconds (FAILS 1 sec threshold)");
        System.out.println("Alg B: 24 ns per run = 0.000000024 sec. 50k runs = 0.0012 seconds (PASSES)");
        System.out.println("Alg C: 1 ns per run = 0.000000001 sec. 50k runs = 0.00005 seconds (PASSES)");
        
        System.out.println("\ne) Sorting Trade-off:");
        System.out.println("If S is number of searches, it is mathematically worthwhile when:");
        System.out.println("O(n log n) + O(S log n) < O(S * n)");
    }
}
