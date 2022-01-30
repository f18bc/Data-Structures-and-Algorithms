/*
// Time O(n^3)
// Space O(1)
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int n = points.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if ((points[j][1] - points[k][1]) * (points[i][0] - points[k][0]) == (points[j][0] - points[k][0]) * (points[i][1] - points[k][1])) {
                        cnt++;
                    }
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}
*/
/*
class Solution {
    // Time O(n^2)
    // Space O(n)
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return n;
        }
        int max = 0;
        for(int i = 0; i < n - 1; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for(int j = i + 1; j < n; j++) {
                double slop = 0;
                if(points[j][0] == points[i][0]) slop = Double.MAX_VALUE;
                else if(points[j][1] == points[i][1]) slop = 0.0d;
                else slop = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                map.put(slop, map.getOrDefault(slop, 1) + 1);
                max = Math.max(max, map.get(slop));
            }
        }
        
        return max;
    }
}
*/
class Solution {
    //
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}