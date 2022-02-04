class Solution {
    // Time O(nk)
    // Space O(k)
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) {
            return 0;
        }
        if (k * 2 >= prices.length) {
            return maxProfitUnlimited(prices);
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < k; i++) {
            buy[i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k-1];
    }
    public int maxProfitUnlimited(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i] - prices[i-1], 0);
        }
        return sum;
    }
}