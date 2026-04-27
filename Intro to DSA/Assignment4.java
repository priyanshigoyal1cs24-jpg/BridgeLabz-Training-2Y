public class Assignment4 {

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Asymptotic Notation Applications ===");
        
        System.out.println("\na) Formal Proof Bubble Sort is O(n^2)");
        System.out.println("Proof: f(n) = n(n-1)/2 = 0.5n^2 - 0.5n");
        System.out.println("We must show there exist literal constants C and n0 such that:");
        System.out.println("f(n) <= C * n^2 for all n >= n0.");
        System.out.println("0.5n^2 - 0.5n <= 0.5n^2 clearly holds true for all n >= 1.");
        System.out.println("Therefore, choosing C=1 and n0=1 proves Bubble Sort logic bounds to O(n^2).\n");
        
        System.out.println("b) Matching Algorithms to Data Profiles");
        System.out.println("Type A (90% Sorted): Insertion Sort. Best Case O(n) because checks short-circuit quickly.");
        System.out.println("Type B (Completely Random): Quick Sort or Merge Sort. Both naturally handle entropy at O(n log n).");
        System.out.println("Type C (Reverse): Merge Sort. (Quick Sort degrades to O(n^2) worst-case without optimal pivot heuristics).");

        System.out.println("\nc) Quick Sort Average Bound vs Merge Sort");
        System.out.println("Merge Sort is bounded EXACTLY to n log n regardless of array state, so it earns Theta(n log n).");
        System.out.println("Quick Sort varies wildly based on pivot luck, so we describe its UPPER asymptotic limit in usual cases with Big-O: O(n log n).");
        
        System.out.println("\nd) Decision Flowchart for Production Architecture");
        System.out.println("IF n < 50 -> ALWAYS INSERTION SORT (zero algorithmic caching overhead)");
        System.out.println("IF n >= 50 AND Data is mostly sorted -> INSERTION SORT");
        System.out.println("IF n >= 50 AND Data is entirely random -> QUICK SORT");
        System.out.println("IF n >= 50 AND Data is reverse/unknown -> MERGE SORT");

        System.out.println("\ne) Mystery Sort T(n) = 5n^2 + 100n + 1000");
        System.out.println("When is Mystery Sort faster than Merge Sort T(n) = 10n log2 n?");
        System.out.println("NEVER at scale. The n^2 polynomial growth dominates n log n universally. Merge Sort is always superior linearly regardless of constants.");
    }
}
