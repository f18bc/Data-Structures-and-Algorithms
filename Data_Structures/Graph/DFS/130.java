class Solution {
    public void solve(char[][] board) {
        int[] directionx = {-1, 1, 0, 0};
        int[] directiony = {0, 0, -1, 1};
        int rows = board.length;
        int cols = board[0].length;
        // We can use Queue and Stack here, for BFS and DFS
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.push(new int[] {i, 0});
            }
            if (board[i][cols-1] == 'O') {
                queue.push(new int[] {i, cols-1});
            }
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                queue.push(new int[] {0, i});
            }
            if (board[rows-1][i] == 'O') {
                queue.push(new int[] {rows-1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.pop();
            board[pos[0]][pos[1]] = 'A';
            for (int i = 0; i < 4; i++) {
                int newx = pos[0] + directionx[i];
                int newy = pos[1] + directiony[i];
                if (newx < 0 || newx >= rows || newy < 0 || newy >= cols || board[newx][newy] != 'O') {
                    continue;
                }
                queue.push(new int[] {newx, newy});
                
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
/*
class Solution {
    public void solve(char[][] board) {
        int[] directionx = {-1, 1, 0, 0};
        int[] directiony = {0, 0, -1, 1};
        int rows = board.length;
        int cols = board[0].length;
        // We can use Queue and Stack here, for BFS and DFS
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
            }
            if (board[i][cols-1] == 'O') {
                queue.offer(new int[] {i, cols-1});
            }
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[] {0, i});
            }
            if (board[rows-1][i] == 'O') {
                queue.offer(new int[] {rows-1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            board[pos[0]][pos[1]] = 'A';
            for (int i = 0; i < 4; i++) {
                int newx = pos[0] + directionx[i];
                int newy = pos[1] + directiony[i];
                if (newx < 0 || newx >= rows || newy < 0 || newy >= cols || board[newx][newy] != 'O') {
                    continue;
                }
                queue.offer(new int[] {newx, newy});
                
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
*/
/*
class Solution {
    char[][] board;
    int rows;
    int cols;
    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            dfs(i, 0);
            dfs(i, cols-1);
        }
        for (int i = 0; i < cols; i++) {
            dfs(0, i);
            dfs(rows-1, i);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return ;
        }
        board[i][j] = 'A';
        dfs(i-1, j);
        dfs(i+1, j);
        dfs(i, j-1);
        dfs(i, j+1);
    }
}
*/