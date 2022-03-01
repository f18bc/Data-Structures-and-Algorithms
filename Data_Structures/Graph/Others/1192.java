class Solution {
    // Time O(V+E)
    // Space O(V+E)
    Map<Integer, Set<Integer>> map;
    List<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        buildMap(connections);
        
        int[] id = new int[n];
        Arrays.fill(id, -1);
        
        dfs(0, 0, -1, id);
        
        return ans;
    }
    
    public int dfs(int node, int nodeID, int par, int[] id) {
        id[node] = nodeID;
        
        Set<Integer> set = map.get(node);
        for (int u : set) {
            if (u == par) { // parent vertex
                continue;
            } else if (id[u] == -1) {
                id[node] = Math.min(id[node], dfs(u, nodeID + 1, node, id));
            } else {
                id[node] = Math.min(id[node], id[u]);
            }
        }
        
        if (id[node] == nodeID && node != 0) {
            ans.add(Arrays.asList(par, node));
        }
        
        return id[node];
    }
    
    public void buildMap(List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            int v1 = connection.get(0);
            int v2 = connection.get(1);
            
            Set<Integer> set1 = map.getOrDefault(v1, new HashSet<>());
            Set<Integer> set2 = map.getOrDefault(v2, new HashSet<>());
            
            set1.add(v2);
            set2.add(v1);
            
            map.put(v1, set1);
            map.put(v2, set2);
        }
    }
}