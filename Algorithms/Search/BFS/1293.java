class Solution {
    // Time O(M * N * min(M + N, K))
    // Space O(M * N * min(M + N, K))
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (k > m + n - 3) {
            return m + n - 2;
        }
        
        boolean[][][] flag = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, k});
        flag[0][0][k] = true;
        int step = 0;
        
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            while (size-- > 0) {
                int[] currentState = q.poll();
                int curm = currentState[0];
                int curn = currentState[1];
                int curk = currentState[2];
                for (int[] direction : directions) {
                    int nextm = curm + direction[0];
                    int nextn = curn + direction[1];
                    if (nextm >= 0 && nextm < m && nextn >= 0 && nextn < n) {
                        if (grid[nextm][nextn] == 0 && !flag[nextm][nextn][curk]) {
                            if (nextm == m - 1 && nextn == n - 1) {
                                return step;
                            } else {
                                flag[nextm][nextn][curk] = true;
                                q.add(new int[]{nextm, nextn, curk});
                            }
                        }
                        else if (grid[nextm][nextn] == 1 && curk > 0 && !flag[nextm][nextn][curk - 1]) {
                            flag[nextm][nextn][curk - 1] = true;
                            q.add(new int[]{nextm, nextn, curk - 1});
                        }
                    }

                }
            }
        }
        return -1;
    }
}