/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        int product = 1;
        int zeroIndex = -1;
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeros++;
                zeroIndex = i;
            } else {
                product *= nums[i];
            }
        }
        
        if (zeros == 1) {
            ans[zeroIndex] = product;
        } else if (zeros == 0) {
            for (int i = 0; i < len; i++) {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0 ; i--) {
            res[i] *= q;
            q *= nums[i];
            
        }
        return res;
    }
}