class Solution {
    public int maxProfit(int[] prices) {
        // Time O(N)
        // Space O(1)
        int sell = Integer.MAX_VALUE;
        int profit = 0;
        for (int i=0;i<prices.length;i++){
            sell = prices[i] < sell ? prices[i] : sell;
            profit = (prices[i]-sell) > profit ? (prices[i]-sell) : profit;
        }
        return profit;
    }
}