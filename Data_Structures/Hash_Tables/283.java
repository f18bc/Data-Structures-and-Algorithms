class Solution {
    // Time O(N)
    // Space O(1)
    // Approach two pointers
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int pointer= 0;
        
        while(zeroPointer < nums.length && pointer < nums.length){
            while(zeroPointer < nums.length && nums[zeroPointer]!=0){
                zeroPointer++;
            }
            if (pointer<=zeroPointer)pointer = zeroPointer;
            while(pointer < nums.length && nums[pointer]==0)pointer++;
            
            if (zeroPointer == nums.length || pointer == nums.length) break;
            int temp = nums[pointer];
            nums[pointer] = nums[zeroPointer];
            nums[zeroPointer] = temp;
            zeroPointer++; // Actually this line is unnecessary
        }
    }
}