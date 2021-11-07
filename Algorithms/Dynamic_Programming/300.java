class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = end;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = nums[i];
            if (right == end) {
                end++;
            }
        }
        return end;
    }
    /*
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int end = 0;
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[end]) {
                end++;
                tails[end] = nums[i];
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails[left] = nums[i];
            }
        }
        return end + 1;
    }
    */
}