class KthLargest {
    // N = nums.length, M = add times
    // Time　O(N+k*logN+M*logk), though solution says O(N*logN+M*logk)
    // Space O(N)
    private static int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq = new PriorityQueue<>();
        for(int ele : nums) pq.offer(ele);
        while(pq.size() > k) pq.poll();        
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>k)pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */