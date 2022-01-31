/*
 * 数组不变，区间查询：前缀和、树状数组、线段树；
 * 数组单点修改，区间查询：树状数组、线段树；
 * 数组区间修改，单点查询：差分、线段树；
 * 数组区间修改，区间查询：线段树。
 **/

// Binary Indexed Tree

// 上来先把三个方法写出来
{
    int[] tree;
    int lowbit(int x) {
        return x & -x;
    }
    // 查询前缀和的方法
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }
    // 在树状数组 x 位置中增加值 u
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }
}

// 初始化「树状数组」，要默认数组是从 1 开始
{
    for (int i = 0; i < n; i++) add(i + 1, nums[i]);
}

// 使用「树状数组」：
{   
    void update(int i, int val) {
        // 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
        add(i + 1, val - nums[i]); 
        nums[i] = val;
    }
    
    int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }
}

// Segment Tree

class Solution {
    class Node {
        int l, r, v, add;
        Node(int _l, int _r) {
            l = _l; r = _r;
        }
    }
    int N = 20009;
    Node[] tr = new Node[N * 4];
    void pushup(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }
    void pushdown(int u) {
        int add = tr[u].add;
        tr[u << 1].v += add;
        tr[u << 1].add += add;
        tr[u << 1 | 1].v += add;
        tr[u << 1 | 1].add += add;
        tr[u].add = 0;
    }
    void build(int u, int l, int r) {
        tr[u] = new Node(l, r);
        if (l != r) {
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
        }
    }
    void update(int u, int l, int r, int v) {
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
    int query(int u, int l, int r) {
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
}
