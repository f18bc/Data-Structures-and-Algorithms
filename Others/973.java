/*
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Map<Integer, List<int[]>> tmap = new TreeMap<>();
        for (int[] point : points) {
            int dis = point[0] * point[0] + point[1] * point[1];
            if (!tmap.containsKey(dis)) {
                tmap.put(dis, new ArrayList<>());
            }
            tmap.get(dis).add(point);
        }
        int in = 0;
        for (List<int[]> l : tmap.values()) {
            for (int i = 0; i < l.size(); i++) {
                ans[in++] = l.get(i);
                if (in >= k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return point1[0] * point1[0] + point1[1] * point1[1] - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        
        return Arrays.copyOfRange(points, 0, k);
    }
}