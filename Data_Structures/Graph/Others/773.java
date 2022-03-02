class Solution {
    // Time O((mn)!⋅mn) Space O((mn)!⋅mn) for BFS
    public int f(String str) {
        int ans = 0;
        char[] cs1 = str.toCharArray(), cs2 = e.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cs1[i * m + j] == '0' || cs2[i * m + j] == '0') {
                    continue;
                }
                int cur = cs1[i * m + j], next = cs2[i * m + j];
                int xd = Math.abs((cur - 1) / 3 - (next - 1) / 3);
                int yd = Math.abs((cur - 1) % 3 - (next - 1) % 3);
                ans += (xd + yd);
            }
        }
        return ans;
    }
    int n = 2, m = 3;
    String s, e;
    int x, y;
    public int slidingPuzzle(int[][] board) {
        s = "";
        e = "123450";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s += board[i][j];
                if (board[i][j] == 0) {
                    x = i; y = j;
                }
            }
        }

        if (!check(s)) return -1;

        int[] dir = {-1, 0, 1, 0, -1};
        Node root = new Node(s, x, y, f(s));
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        Map<String, Integer> map = new HashMap<>();
        pq.add(root);
        map.put(s, 0);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int step = map.get(node.str);
            if (node.str.equals(e)) return step;
            int dx = node.x, dy = node.y;
            for (int k = 0; k < 4; k++) {
                int nx = dx + dir[k], ny = dy + dir[k + 1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                String nStr = update(node.str, dx, dy, nx, ny);
                if (!map.containsKey(nStr) || map.get(nStr) > step + 1) {
                    Node next = new Node(nStr, nx, ny, step + 1 + f(nStr));
                    pq.add(next);
                    map.put(nStr, step + 1);
                }
            }
        }
        return -1;
    }
    public String update(String cur, int i, int j, int p, int q) {
        char[] cs = cur.toCharArray();
        char tmp = cs[i * m + j];
        cs[i * m + j] = cs[p * m + q];
        cs[p * m + q] = tmp;
        return String.valueOf(cs);
    }
    public boolean check(String str) {
        char[] cs = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n * m; i++) {
            if (cs[i] != '0') list.add(cs[i] - '0');
        }
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) cnt++;
            }
        }
        return cnt % 2 == 0;
    } 
}
class Node {
    String str;
    int x, y;
    int val;
    Node(String _str, int _x, int _y, int _val) {
        str = _str; x = _x; y = _y; val = _val;
    }
}