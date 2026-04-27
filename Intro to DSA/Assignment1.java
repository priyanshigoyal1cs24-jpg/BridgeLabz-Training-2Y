public class Assignment1 {

    // Algorithm A: Calculates average correctly
    public static double algorithmA(float[] temperature, int n) {
        if (n <= 0) return 0;
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += temperature[i];
        }
        return total / n;
    }

    // Algorithm B: Logical error included
    // In original Pseudocode: array was 1-indexed, loop from 2 to n. 
    // And sum = sum / n inside the loop.
    public static double algorithmB(float[] temperature, int n) {
        if (n <= 0 || temperature.length == 0) return 0;
        // Simulating 1-indexed by using index 0 as starting point
        double sum = temperature[0];
        
        // Loop from second element
        for (int i = 1; i < n; i++) {
            sum += temperature[i];
        }
        // In the flawed algorithm, division was in a loop, but here is the logical structure
        // we write to demonstrate what happens if you divide at the end properly vs not
        for (int i = 0; i < n; i++) {
            sum = sum / n; // The logical error mapped
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Algorithm Properties & Correctness ===");
        
        float[] temps = {20f, 25f, 22f, 24f, 21f};
        int n = 5;

        System.out.println("\nTesting Algorithm A with inputs [20, 25, 22, 24, 21]:");
        System.out.println("Output: " + algorithmA(temps, n)); 

        System.out.println("\nTesting Algorithm B with inputs [20, 25, 22, 24, 21]:");
        System.out.println("Output: " + algorithmB(temps, n));

        System.out.println("\n--- Evaluation ---");
        System.out.println("Algorithm A produces the correct mathematical average (22.4).");
        System.out.println("Algorithm B produces an incorrect result heavily diluted by the looping division flaw, violating the mathematical principle of averaging.");
        
        System.out.println("\n--- Test Strategy ---");
        System.out.println("1. Normal case: n=5, temp=[20, 25, 22, 24, 21]");
        System.out.println("2. Edge case (n=1): temp=[25]");
        System.out.println("3. Edge case (n=0): temp=[] (Testing zero division handling)");
        System.out.println("4. Negative ranges: temp=[-5, -10, 0, 2]");
        System.out.println("5. Extreme numbers to test datatype overflow.");
    }
}
