public class WordPuzzle {

    private static final int[][] DIRS = {
        {-1,0}, {1,0}, {0,-1}, {0,1}, 
        {-1,-1}, {-1,1}, {1,-1}, {1,1}
    };

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (backtrack(board, word, 0, r, c, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int index, int r, int c, boolean[][] visited) {
        // Goal achieved
        if (index == word.length()) {
            return true;
        }

        // Constraints and bounds check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length 
            || visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Make choice
        visited[r][c] = true;

        // Traverse 8 directions recursively
        for (int[] d : DIRS) {
            if (backtrack(board, word, index + 1, r + d[0], c + d[1], visited)) {
                return true;
            }
        }

        // Undo choice
        visited[r][c] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'C', 'A', 'T', 'S'},
            {'O', 'R', 'E', 'A'},
            {'D', 'E', 'A', 'M'},
            {'E', 'L', 'L', 'S'}
        };
        String target = "DREAM";
        
        System.out.println("Can form word '" + target + "': " + exist(grid, target));
    }
}
