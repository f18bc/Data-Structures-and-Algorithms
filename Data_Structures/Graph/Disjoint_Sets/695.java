class Solution {
    // Time O (mn)
    // Space O (mn)
    // 30mins
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (i + 1 < rows && grid[i+1][j] == 1) {
                        uf.union(i * columns + j, (i + 1) * columns + j);
                    }
                    if (j + 1 < columns && grid[i][j+1] == 1) {
                        uf.union(i * columns + j, i * columns + (j + 1));
                    }
                }
            }
        }
        
        return uf.getMax();
    }
    class UnionFind {
        int[] size;
        int[] parent;
        int rows;
        int columns;
        public UnionFind(int[][] grid) {
            this.rows = grid.length;
            this.columns = grid[0].length;
            this.size = new int[rows * columns];
            this.parent = new int[rows * columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == 1) {
                        parent[i * columns + j] = i * columns + j;
                        size[i * columns + j] = 1;
                    }
                    
                }
            }
        }
        
        public int find(int x) {
            int y = parent[x];
            if (y != x) {
                y = find(parent[x]);
            }
            return y;
        }
        
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (size[rootx] <= size[rooty]) {
                    parent[rootx] = rooty;
                    size[rooty] += size[rootx];
                    
                } else {
                    parent[rooty] = rootx;
                    size[rootx] += size[rooty];
 
                }
            }
        }
        
        public int getMax() {
            int max = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    max = Math.max(max, size[i * columns + j]);
                }
            }
            return max;
        }
    }
}