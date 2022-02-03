/*
 * 1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 * 2. Find the largest index l greater than k such that a[k] < a[l].
 * 3. Swap the value of a[k] with that of a[l].
 * 4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int in1 = -1;
        int in2 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                in1 = i;
                break ;
            }
        }
        
        if (in1 != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[in1]) {
                    in2 = i;
                    break ;
                }
            }
        }

        if (in1 == -1) {
            reverse(nums, 0, nums.length - 1);
        } else if (in2 == -1) {
            reverse(nums, in1 + 1, nums.length - 1);
        } else {
            swap(nums, in1, in2);
            reverse(nums, in1 + 1, nums.length - 1);
        }
    }
    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
