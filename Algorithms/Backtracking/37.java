class Solution {
    // Time O(9^m), m is the number of blanks
    // Space O(1) 81
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return ;
        }
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true; // when the rest are filled
    }
    public boolean isValid(char[][] board, int row, int col, char ch) {
        int regionRow = 3 * (row / 3);
        int regionCol = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) return false;
            if (board[row][i] == ch) return false;
            if (board[regionRow + i / 3][regionCol + i % 3] == ch) return false;
        }
        return true;
    }
}
