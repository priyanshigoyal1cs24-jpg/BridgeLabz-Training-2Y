import java.util.*;

public class NQueens {
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        // 1D array optimization: board[row] = column
        int[] board = new int[n]; 
        
        // Track diagonals efficiently
        boolean[] cols = new boolean[n];
        boolean[] leftDiag = new boolean[2 * n - 1]; // row + col
        boolean[] rightDiag = new boolean[2 * n - 1]; // row - col + n - 1
        
        backtrack(0, n, board, cols, leftDiag, rightDiag, solutions);
        return solutions;
    }
    
    private static void backtrack(int row, int n, int[] board, 
                                  boolean[] cols, boolean[] leftDiag, boolean[] rightDiag, 
                                  List<List<String>> solutions) {
        if (row == n) {
            solutions.add(constructBoard(board, n));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols[col] || leftDiag[row + col] || rightDiag[row - col + n - 1]) {
                continue; // Prune branch early
            }
            
            // Make choice
            board[row] = col;
            cols[col] = true;
            leftDiag[row + col] = true;
            rightDiag[row - col + n - 1] = true;
            
            // Recurse
            backtrack(row + 1, n, board, cols, leftDiag, rightDiag, solutions);
            
            // Undo choice (Backtrack)
            cols[col] = false;
            leftDiag[row + col] = false;
            rightDiag[row - col + n - 1] = false;
        }
    }
    
    private static List<String> constructBoard(int[] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[i]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("Total solutions for N=" + n + ": " + solutions.size());
        
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i+1) + ":");
            for (String row : solutions.get(i)) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
