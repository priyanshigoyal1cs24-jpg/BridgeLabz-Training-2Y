import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    
    // Calculates stock span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        
        // Stack will hold indices of the days
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while price at stack top is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            // If stack is empty, all previous prices are smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            
            // Push current index to stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Spans: " + Arrays.toString(spans));
    }
}
