import java.util.Stack;

public class ExpressionTree {
    
    // Evaluates a Postfix expression leveraging Stack
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ') continue;
            
            // If operand, push
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } 
            // If operator, pop two and compute
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch (c) {
                    case '+': stack.push(val2 + val1); break;
                    case '-': stack.push(val2 - val1); break;
                    case '*': stack.push(val2 * val1); break;
                    case '/': stack.push(val2 / val1); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Expression Tree Evaluation ===");
        
        // Tree: (3+5) * (8-2)
        // Postorder (postfix): 3 5 + 8 2 - *
        String postfix = "3 5 + 8 2 - *";
        
        System.out.println("a) Postorder formulation implicitly gives postfix tracking: " + postfix);
        System.out.println("b) Inorder with constraints gives infix: (3 + 5) * (8 - 2)");
        System.out.println("c) Preorder generates prefix notation parsing.");
        System.out.println("d) Evaluating postfix array via stack yields runtime mathematical answer: ");
        System.out.println("Solution: " + evaluatePostfix(postfix)); // Expected 48
    }
}
