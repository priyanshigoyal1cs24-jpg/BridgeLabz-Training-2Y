public class BSTOperations {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }
    
    Node root;

    // Standard insertion
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) root.left = insertRec(root.left, val);
        else if (val > root.val) root.right = insertRec(root.right, val);
        return root;
    }

    // Standard deletion handling 3 leaf cases
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private Node deleteRec(Node root, int val) {
        if (root == null) return root;

        if (val < root.val) root.left = deleteRec(root.left, val);
        else if (val > root.val) root.right = deleteRec(root.right, val);
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor
            root.val = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }
    
    // Inorder traversal to print
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BSTOperations bst = new BSTOperations();
        int[] vals = {15, 10, 20, 8, 12, 17, 25};
        for (int v : vals) bst.insert(v);
        
        System.out.print("Inorder before deletion: ");
        bst.inorder();
        
        bst.delete(10);
        
        System.out.print("Inorder after deleting 10: ");
        bst.inorder();
        
        bst.insert(14);
        bst.insert(9);
        
        System.out.print("Inorder after inserting 14, 9: ");
        bst.inorder();
    }
}
