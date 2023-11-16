package DAA_Lab;

public class n_queen{

    public static void main(String[] args) {
        int n1 = 4; // Board size for the first scenario
        int n2 = 8; // Board size for the second scenario

        System.out.println("Solution for " + n1 + " Queens:");
        printNQueens(n1);

    }

    public static void printNQueens(int n) {
        int[][] board = new int[n][n];
        // Place the first queen and continue with backtracking
        placeQueens(board, 1, n);
        // Print the final N-Queens matrix
        printBoard(board);
    }

    private static boolean placeQueens(int[][] board, int col, int n) {
        if (col > n) {
            return true; // All queens are placed successfully
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col - 1] = 1; // Place queen (adjusting for 0-based indexing)

                // Recur for the next column
                if (placeQueens(board, col + 1, n)) {
                    return true;
                }

                // If placing queen in the current position doesn't lead to a solution, backtrack
                board[row][col - 1] = 0; // Backtrack
            }
        }

        return false; // No valid placement for the current column
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check if there is a queen in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the upper diagonal on the left side
        for (int i = row, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the lower diagonal on the left side
        for (int i = row, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
