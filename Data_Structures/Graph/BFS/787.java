class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Time O(k * n * n)
        // Space O(n)
        // Time Limit Exceeded for so many times without pruning
        int min = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        List<int[]>[] f = new List[n];
        for (int i = 0; i < n; i++) {
            f[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            f[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] node = queue.poll();
                int from = node[0];
                int priceSoFar = node[1];

                for (int[] flight : f[from]) {     
                    int newprice = priceSoFar + flight[1];
                    // pruning
                    // newprice should be less than from source to current point
                    // and less than from source to dst
                    if (newprice < ans[flight[0]] && newprice < ans[dst]) {
                        ans[flight[0]] = newprice;
                        // prune, stop when reach dst
                        if (flight[0] != dst) {
                            queue.offer(new int[] {flight[0], newprice});
                        }
                    }
                }
            }
            k--;
        }
        
        if (ans[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans[dst];
        }
    }
}

/* Time Limited exceeded
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int min = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        
        int stop = 0;
        
        while (!queue.isEmpty() && stop <= k) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] node = queue.poll();
                int from = node[0];
                int price = node[1];

                for (int[] flight : flights) {     
                    if (flight[0] == from) {
                        if (flight[1] == dst) {
                            if (min == -1) {
                                min = price + flight[2];
                            } else{
                                min = Math.min(min, price + flight[2]);
                            }
                        } else {
                            queue.offer(new int[] {flight[1], price + flight[2]});
                        }
                    }
                }
            }
            stop++;

        }
        return min;
    }
}
*/