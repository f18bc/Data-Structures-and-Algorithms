class Solution {
    // Time O(mn)
    // Space O(mn)
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
                
            }
        }
        
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] <= rank[rooty]) {
                    parent[rootx] = rooty;
                    if (rank[rootx] == rank[rooty]) {
                        rank[rooty]++;
                    }
                } else {
                    parent[rootx] = rooty;
                }
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }

    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int columns = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
				if(grid[i][j]=='1') {
					grid[i][j]='0';
                    if (i + 1 < rows && grid[i+1][j] == '1') {
                        uf.union(i * columns + j, (i+1) * columns + j);
                    }
                    if (j + 1 < columns && grid[i][j+1] == '1') {
                        uf.union(i * columns + j, i * columns + j + 1);
                    }
				}
            }
        }
        

        
        return uf.getCount();
    }
}