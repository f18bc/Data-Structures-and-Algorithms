class Solution {
    public int maxSubArray(int[] nums) {
        // Time O(N)
        // Space O(1)
        // Optimized DP (Tabulation) for mathematically better understanding
        int globalSum = nums[nums.length-1];
        int localSum = 0;
        for(int i=nums.length-1;i>=0;i--){
            localSum += nums[i];
            if(localSum>globalSum)globalSum=localSum;
            if(localSum<0) localSum=0;
        }
        return globalSum;
        
    }
}