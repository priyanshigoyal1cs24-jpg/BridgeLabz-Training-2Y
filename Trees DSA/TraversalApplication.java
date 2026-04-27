public class TraversalApplication {

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Traversal Application ===");
        
        System.out.println("\na) Alphabetical file formatting traversal?");
        System.out.println("If it is a BST, we use **Inorder Traversal** (Left-Root-Right) to access files iteratively in ascending alphabetical order.");
        
        System.out.println("\nb) Calculate total size of directory traversal?");
        System.out.println("We must use **Postorder Traversal**. You logically must calculate the aggregated size of all children before assigning size constraints to the parent directory.");
        
        System.out.println("\nc) Create a backup traversing structure?");
        System.out.println("We must use **Preorder Traversal**. You have to instantiate the parent 'root' directory before you are capable of pasting the children dependencies inside it.");
        
        System.out.println("\nd/e) Postorder application in deletion:");
        System.out.println("Just like calculating size, you must use **Postorder** for safe deletion. Deleting a parent before its children isolates the children into unrecoverable memory leak space.");
    }
}
