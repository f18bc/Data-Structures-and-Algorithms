class Solution {
    // Time O(MNlog(MN))
    // Space O(MN)
    int[] p = new int[10000]; // N * M <= 10000
    int row;
    int col;
    public void union(int x, int y) {
        p[find(x)] = p[find(y)];
    }
    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public boolean isPath(int x, int y) {
        return p[find(x)] == p[find(y)];
    }
    public int getIndex(int i, int j) {
        return i * col + j;
    }
    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        
        for (int i = 0; i < row * col; i++) {
            p[i] = i;
        }
        
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int a = getIndex(i, j);
                if (i+1 < row) {
                    int b = getIndex(i+1, j);
                    edges.add(new int[] {a, b, Math.abs(heights[i+1][j] - heights[i][j])});
                }
                if (j+1 < col) {
                    int b = getIndex(i, j+1);
                    edges.add(new int[] {a, b, Math.abs(heights[i][j+1] - heights[i][j])});
                }
            }
        }
        int start = getIndex(0, 0);
        int end = getIndex(row-1, col-1);
        Collections.sort(edges, (a,b) -> a[2]-b[2]); // Sort by weight
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            union(a, b);
            if (isPath(start, end)) {
                return edge[2];
            }
        }
        
        return 0;
    }
}