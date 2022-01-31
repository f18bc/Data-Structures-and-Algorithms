/*
class Solution {
    // Time O(m + n)
    // Space O(n)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int[] bo : bookings) {
            int l = bo[0] - 1, r = bo[1] - 1, v = bo[2];
            diff[l] += v;
            diff[r + 1] -= v;
        }
        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
*/
class Solution {
    // Time O(mlogn + nlogn)
    // Space O(n)
    class Node {
        int l, r, v, add;
        public Node(int _l, int _r) {
            l = _l;
            r = _r;
        }
    }
    int N = 20009;
    Node[] tr = new Node[N * 4];
    public void pushup(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }
    public void pushdown(int u) {
        int add = tr[u].add;
        tr[u << 1].v += add;
        tr[u << 1].add += add;
        tr[u << 1 | 1].v += add;
        tr[u << 1 | 1].add += add;
        tr[u].add = 0;
    }
    public void build(int u, int l, int r) {
        tr[u] = new Node(l, r);
        if (l != r) {
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
        }
    }
    public void update(int u, int l, int r, int v) {
        if (l <= tr[u].l && tr[u].r <= r) {
            tr[u].v += v;
            tr[u].add += v;
        } else {
            pushdown(u);
            int mid = tr[u].l + tr[u].r >> 1;
            if (l <= mid) update(u << 1, l, r, v);
            if (r > mid) update(u << 1 | 1, l, r, v);
            pushup(u);
        }
    }
    public int query(int u, int l, int r) {
        if (l <= tr[u].l && tr[u].r <= r) {
            return tr[u].v;
        } else {
            pushdown(u);
            int mid = tr[u].l + tr[u].r >> 1;
            int ans = 0;
            if (l <= mid) ans += query(u << 1, l, r);
            if (r > mid) ans += query(u << 1 | 1, l, r);
            return ans;
        }
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        build(1, 1, n);
        for (int[] bo : bookings) {
            update(1, bo[0], bo[1], bo[2]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = query(1, i + 1, i + 1);
        }
        return ans;
    }
}