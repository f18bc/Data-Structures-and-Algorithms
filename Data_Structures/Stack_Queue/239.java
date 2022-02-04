class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Time O(n)
        // Space O(k)
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (dq.getFirst() + k <= i) {
                dq.pollFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return ans;
    }
}