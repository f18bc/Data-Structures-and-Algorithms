class Solution {
    int[] originalArr;
    int[] curArr;
    public Solution(int[] nums) {
        originalArr = nums.clone();
        curArr = nums;
    }
    
    public int[] reset() {
        curArr = originalArr;
        originalArr = originalArr.clone();
        return curArr;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < originalArr.length; i++) {
            int rand = (int) (Math.random() * originalArr.length);
            swap(curArr, i, rand);
        }
        return curArr;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */