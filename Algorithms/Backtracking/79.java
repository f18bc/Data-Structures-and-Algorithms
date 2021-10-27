class Solution {
    // Time O(mn*3^word.length)
    // O(MN)
    int row;
    int col;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[] visited = new boolean[row*col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                helper(board, i, j, word, 0, visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    public void helper(char[][] board, int i, int j, String word, int in, boolean[] visited) {
        if (in == word.length()) {
            flag = true;
            return;
        }
        if (i >= row || i < 0 || j >= col || j < 0 || visited[i * col + j] || word.charAt(in) != board[i][j]) {
            return;
        }
        visited[i * col + j] = true;
        helper(board, i + 1, j, word, in + 1, visited);
        helper(board, i, j + 1, word, in + 1, visited);
        helper(board, i - 1, j, word, in + 1, visited);
        helper(board, i, j - 1, word, in + 1, visited);
        visited[i * col + j] = false;
    }
}