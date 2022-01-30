class Solution {
    // Time O(N)
    // Space O(N)
    // 35 min, too much on debugging 
    private int rows;
    private int columns;
    public void solve(char[][] board) {
        this.rows = board.length;
        this.columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, columns - 1);
        }
        for (int i = 0; i < columns; i++) {
            dfs(board, 0, i);
            dfs(board, rows - 1, i);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != 'S') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= columns || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'S';
        dfs(board, x - 1, y);
        dfs(board, x, y - 1);
        dfs(board, x + 1, y);
        dfs(board, x, y + 1);
    }
}