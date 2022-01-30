/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<>();
        return dfs(node);
    }
    public Node dfs(Node node) {
        // if node is visited, we return its value from hashmap
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val); // clone node
        map.put(node, clone); // build edges from node to clone
        for (Node neighbor : node.neighbors) { // clone egdes (neighbors)
            clone.neighbors.add(dfs(neighbor));
        }
        return clone;
    }
}
/*
// BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
*/