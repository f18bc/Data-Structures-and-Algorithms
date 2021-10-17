class Solution {
    public int numSquares(int n) {
        List<Integer> squareNums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squareNums.add(i * i);
        }
        
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            level++;
            Set<Integer> nextQueue = new HashSet<>();
            
            for (Integer remainder : queue) {
                for (Integer square : squareNums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        continue;
                    } else {
                        nextQueue.add(remainder - square);
                    }
                }
            }
            queue = nextQueue;
        }
        return level;
    }
    /*
    //
    // O(N * sqrt(N))
    // O(N)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }*/
}