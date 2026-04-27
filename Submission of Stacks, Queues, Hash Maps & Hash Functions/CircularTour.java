public class CircularTour {
    
    // Petrol pump data structure conceptually
    // Represented by two arrays for simplicity
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;
        
        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i];
            
            // If at any point surplus goes negative, the previous starting point is invalid
            if (surplus < 0) {
                start = i + 1; // Next possible start
                deficit += surplus; // Store to see if we can make it up later
                surplus = 0; // Reset current surplus
            }
        }
        
        // If total petrol is more than total distance, a tour is possible
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        
        int start = findStartingPoint(petrol, distance);
        if (start == -1) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Starting point index: " + start);
        }
    }
}
