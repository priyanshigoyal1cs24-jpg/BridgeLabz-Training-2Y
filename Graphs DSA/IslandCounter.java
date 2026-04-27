import java.util.*;

public class IslandCounter {
    
    // Method to count islands using DFS
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private static void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Out of bounds or water
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
            return;
        }
        
        // Sink the island fragment
        grid[r][c] = 0;
        
        // Visit 4 neighbors (up, down, left, right)
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        
        // If diagonals were allowed, we'd add 4 more recursive calls here:
        // dfs(grid, r-1, c-1); dfs(grid, r+1, c+1); 
        // dfs(grid, r-1, c+1); dfs(grid, r+1, c-1);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        };
        
        int islands = countIslands(grid);
        System.out.println("Total islands found: " + islands);
    }
}
