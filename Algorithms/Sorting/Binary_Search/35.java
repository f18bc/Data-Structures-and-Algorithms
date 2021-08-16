class Solution {
    // Time O(N)
    // Space O(N)
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left) /2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid+1;
            else right = mid-1;
        }

        return left;
    }
    /*public int searchInsert(int[] nums, int target) {
        if (nums[nums.length-1]<target) return nums.length;
        if (nums[0]>target) return 0;
        int left = 0, right = nums.length-1;
        while(left+1<right){
            int mid = left + (right-left) /2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid;
            else right = mid;
        }
        if (target < nums[left]) return left -1;
        else if (target == nums[left]) return left;
        else if (target > nums[right]) return right +1;
        else return right;
    }*/
}
