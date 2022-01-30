class Solution {
    // Boyer Moore Voting
    // Time O(N)
    // Space O(1)
    public int majorityElement(int[] nums){
        int count = 0;
        int anw = 0; // Integer anw = null;
        
        for (int ele : nums){
            if (count==0) anw = ele;
            count += anw == ele ? 1 : -1;
        }
        return anw;
    }
    
    /*
    // Divide and Conquer
    public int majorityElement(int[] nums) {
        // Time O(NlogN)
        // Space O(logN)
        return divideHelper(nums, 0, nums.length-1);
    }
    public int countInRange(int[] arr, int num, int left, int right){
        int count = 0;
        for(int i = left; i<=right; i++){
            if(arr[i]==num)count++;
        }
        return count;
    }
    public int divideHelper(int[] arr, int left, int right){
        if(left==right) return arr[left];
        
        int mid = left + (right-left)/2;
        int leftMajor = divideHelper(arr,left,mid);
        int rightMajor = divideHelper(arr,mid+1,right);
        
        if(leftMajor==rightMajor) return leftMajor;
        int leftCount = countInRange(arr,leftMajor,left,right);
        int rightCount = countInRange(arr,rightMajor,left,right);
        
        return leftCount > rightCount ? leftMajor : rightMajor;
    }
    */
    
    /*
    //HashMap
    public int majorityElement(int[] nums) {
        // Time O(N)
        // Space O(N)
        Map<Integer,Integer> hMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(hMap.containsKey(nums[i])){
                hMap.replace(nums[i], hMap.get(nums[i])+1);
            } else hMap.put(nums[i],1);
            if(hMap.get(nums[i])>nums.length/2) return nums[i];
        }
        return -1;
    }
    */
}