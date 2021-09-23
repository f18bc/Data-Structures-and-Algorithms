class Solution {
    // Time O(N)
    // Space O(1)
    // Space-optimized Tabulation (bottom-up)
    public int minCostClimbingStairs(int[] cost) {
        // f(n) = Math.min((f(n-1) +cost[i-1]),(f(n-2)+cost[i-2]))
        int len = cost.length;
        int s1 = 0; // Taking one step from previous florr
        int s2 = 0; // Taking two steps from previous floor
        
        // We build a sentinel and take len+1 instead of len here 
        // Since we can either reach the end or end+1
        for(int i = 2;i<len+1;i++) {
            int temp = s2;
            s2 = Math.min(s2+cost[i-1],s1+cost[i-2]);
            s1 = temp;
        }
        
        // The two-step method will always arrive at end+1 or end first
        return s2;
    }
    // Tabulation & Memorization for practice, Time O(N), Space O(N)
    
    /*
    // Tabulation (bottom up)
    public int minCostClimbingStairs(int[] cost) {
        // f(n) = Math.min((f(n-1) +cost[i-1]),(f(n-2)+cost[i-2]))
        int len = cost.length;
        int[] minCost = new int[len+1];
        minCost[0] = 0;
        minCost[1] = 0;
        
        for(int i = 2;i<len+1;i++) {
           minCost[i] = Math.min(minCost[i-1]+cost[i-1], minCost[i-2]+cost[i-2]);
        }
        
        return minCost[len];
    }
    */
    /*
    // Memorization (top down)
    private Map<Integer,Integer> hmap;
    public int minCostClimbingStairs(int[] cost) {
        hmap = new HashMap<>();
        return memoHelper(cost, cost.length);
    }
    public int memoHelper(int[] cost, int i){
        if(i<=1) {
            return 0;
        }
        
        if(hmap.containsKey(i)) {
            return hmap.get(i);
        }
        
        hmap.put(i, Math.min(memoHelper(cost,i-1)+cost[i-1], memoHelper(cost,i-2)+cost[i-2]));
        
        return hmap.get(i);
    }
    */
}