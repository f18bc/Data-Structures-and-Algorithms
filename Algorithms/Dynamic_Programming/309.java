class Solution {
    public int maxProfit(int[] prices) {
        // 无股买 buy
        // 有股不卖 s1
        // 有股卖 sell
        // 有股不卖 s2
        // Time O(n)
        // Space O(n)
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];
        buy[0] = -prices[0];
        s1[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = s2[i-1] - prices[i];
            s1[i] = Math.max(buy[i-1], s1[i-1]);
            sell[i] = Math.max(buy[i-1], s1[i-1]) + prices[i];
            s2[i] = Math.max(s2[i-1], sell[i-1]);
        }
        return Math.max(sell[n-1], s2[n-1]);
    }
}