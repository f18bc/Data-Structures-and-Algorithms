class Solution {
    // Time O(Sn)
    // Space O(S)
    // 30min
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memo[i-coins[j]] < min) {
                    min = memo[i-coins[j]] + 1;
                }
            }
            memo[i] = min;
        }
        
        if (memo[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return memo[amount];
        }
    }
    /*
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount];
        return helper(coins, amount);
    }
    
    private int helper(int[] coins, int rem) {
        if (rem < 0) {
            return -1;
        }
        
        if (rem == 0) {
            return 0;
        }
        
        if (memo[rem-1] != 0) {
            return memo[rem-1];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < coins.length; i++) {
            int next = helper(coins, rem - coins[i]);
            if (next >= 0 && next < min) {
                min = next + 1;
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            memo[rem-1] = -1;
        } else {
            memo[rem-1] = min;
        }
        
        return memo[rem-1];
    }
    */
}