// Time O(M+N)
// Space O(N)

// UnionFind
class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] visited = new int[length];
        UnionFind uf = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int neighbor : graph[i]) {
                if (uf.find(i) == uf.find(neighbor)) {
                    return false;
                }
                uf.union(graph[i][0], neighbor);
            }
        }
        return true;
    }
}
/*
// simple UnionFind
class UnionFind {
    int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            x = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}
*/
// optimized UnionFind by rank
class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            x = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] <= rank[rooty]) {
                parent[rootx] = rooty;
                rank[rooty]++;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }
}


/*
// DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] visited = new int[length];
        for (int i = 0; i < length; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int color, int[] visited) {
        if (visited[node] != 0) {
            return visited[node] == color;
        }
        visited[node] = color;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, -color, visited)) {
                return false;
            }
        }
        return true;
    }
}
*/

/*
// BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] visited = new int[length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            visited[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (visited[node] == visited[neighbor]) {
                        return false;
                    }
                    if (visited[neighbor] == 0) {
                        visited[neighbor] = -visited[node];
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return true;
    }
}
*/