class Solution {
    /*
    int[] nums = new int[] {2,3,5};
    public int nthUglyNumber(int n) {
        Set<Long> hset = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        int total = 0;
        hset.add(1L);
        for (int i = 1; i <= n; i++) {
            long value = pq.poll();
            if (i == n) {
                return (int)value;
            }
            for (int num : nums) {
                long t = num * value;
                if (!hset.contains(t)) {
                    hset.add(t);
                    pq.add(t);
                }
            }

        }
        return -1;
    }
    */
    
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n+1];
        ugly[1] = 1;
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        for (int i = 2; i <= n; i++) {
            int n2 = 2 * ugly[i2];
            int n3 = 3 * ugly[i3];
            int n5 = 5 * ugly[i5];
            ugly[i] = Math.min(n2, Math.min(n3, n5));
            if (ugly[i] == n2) {
                i2++;
            }
            if (ugly[i] == n3) {
                i3++;
            } 
            if (ugly[i] == n5) {
                i5++;
            }
        }
        return ugly[n];
    }
}
