import java.util.Stack;

public class RecursionMechanics {

    // Helper abstract class to test recursive mechanics
    static class Node {
        String name;
        int size;
        boolean isFile;
        Node[] children;
        
        Node(String name, int size, boolean isFile) {
            this.name = name;
            this.size = size;
            this.isFile = isFile;
            this.children = new Node[0];
        }
    }
    
    public static int getDirectorySize(Node root) {
        // Base case: If leaf node file, return absolute space
        if (root.isFile) return root.size;
        
        // Recursive loop evaluating child nested branches
        int total = 0;
        for (Node child : root.children) {
            total += getDirectorySize(child);
        }
        return total;
    }
    
    // Translating recursive logic to explicit dynamic stack manipulation
    public static int getDirectorySizeIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int total = 0;
        
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.isFile) {
                total += curr.size;
            } else {
                for (Node child : curr.children) stack.push(child);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Understanding Recursion Mechanics ===");
        
        Node project = new Node("project", 0, false);
        Node src = new Node("src", 0, false);
        Node docs = new Node("docs", 0, false);
        Node guides = new Node("guides", 0, false);
        
        Node main = new Node("main.java", 100, true);
        Node utils = new Node("utils.java", 50, true);
        Node readme = new Node("readme.txt", 10, true);
        Node setup = new Node("setup.pdf", 200, true);
        Node config = new Node("config.xml", 20, true);
        
        guides.children = new Node[]{setup};
        docs.children = new Node[]{readme, guides};
        src.children = new Node[]{main, utils};
        project.children = new Node[]{src, docs, config};
        
        System.out.println("Executing Recursive Space Search: " + getDirectorySize(project) + " KB");
        System.out.println("Executing Iterative Manual Stack Search: " + getDirectorySizeIterative(project) + " KB");
        
        System.out.println("\nIterative handles extreme node depth inherently without causing StackOverflow exceptions.");
    }
}
