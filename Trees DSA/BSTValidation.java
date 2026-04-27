public class BSTValidation {
    
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }
    
    // Validates if tree is a BST using Min/Max bounding
    public static boolean isValidBST(Node root) {
        return validate(root, null, null);
    }
    
    private static boolean validate(Node node, Integer min, Integer max) {
        // Base case: empty tree is a valid BST
        if (node == null) return true;
        
        // Node value violates max boundary
        if (max != null && node.val >= max) return false;
        
        // Node value violates min boundary
        if (min != null && node.val <= min) return false;
        
        // Recursively validate left and right subtrees
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        /*
            Valid BST Example:
                  50
                 /  \
               30    70
              / \    / \
            20  40  60  80
        */
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        
        System.out.println("Is tree a valid BST? " + isValidBST(root));
        
        // Break the BST
        root.left.right.val = 55; // 55 > 50, but it is in the left subtree of 50
        System.out.println("Is tree still a valid BST? " + isValidBST(root));
    }
}
