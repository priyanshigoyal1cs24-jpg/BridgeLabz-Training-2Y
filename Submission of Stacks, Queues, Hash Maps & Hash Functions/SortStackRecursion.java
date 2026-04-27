import java.util.Stack;

public class SortStackRecursion {
    
    // Sorts the stack iteratively internally using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            // Recursively sort the remaining stack
            sortStack(stack);
            // Insert the popped element back into sorted stack
            insertSorted(stack, top);
        }
    }
    
    // Helper function to insert an element into the sorted stack
    private static void insertSorted(Stack<Integer> stack, int item) {
        // If stack is empty or top is smaller than item, push it
        if (stack.isEmpty() || stack.peek() <= item) {
            stack.push(item);
            return;
        }
        // Otherwise pop the top and recurse
        int top = stack.pop();
        insertSorted(stack, item);
        // Put the top back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Original Stack: " + s);
        sortStack(s);
        System.out.println("Sorted Stack: " + s);
    }
}
