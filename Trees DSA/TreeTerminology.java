public class TreeTerminology {
    
    // Abstracting a very basic node for organizational chart
    static class Node {
        String role;
        Node left, right;
        Node(String role) { this.role = role; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Tree Terminology Identification ===");
        
        // Build the Tree
        Node root = new Node("CEO");
        root.left = new Node("CTO");
        root.right = new Node("CFO");
        root.left.left = new Node("Dev Lead");
        root.left.right = new Node("HR");
        root.left.left.left = new Node("Dev1");
        root.left.left.right = new Node("Dev2");

        System.out.println("\na) Identify all leaf nodes:");
        System.out.println("Leaves are nodes with no children: [HR], [Dev1], [Dev2], [CFO]");
        System.out.println("Note: CFO is a leaf because it has no direct children in the given tree representation.");

        System.out.println("\nb) What is the height of the tree?");
        System.out.println("Height = longest path from root to leaf = 3 (CEO -> CTO -> Dev Lead -> Dev1)");

        System.out.println("\nc) What is the depth of 'Dev Lead'?");
        System.out.println("Depth = edges from root. CEO(0) -> CTO(1) -> Dev Lead(2). Depth is 2.");

        System.out.println("\nd) List all ancestors of 'Dev1'");
        System.out.println("Ancestors: Dev Lead, CTO, CEO");

        System.out.println("\ne) What is the degree of the CTO node?");
        System.out.println("Degree = number of direct children. CTO has 'Dev Lead' and 'HR'. Degree is 2.");
    }
}
