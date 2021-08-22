/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Time O(N)
    // Space O(N)
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);

    }
    public TreeNode helper(int[] nums,int left, int right){
        if (left>right) return null;
        int rootIndex = (left+right)/2;
        if ((left+right) % 2 == 1) rootIndex+=new Random().nextInt(2); // Fun solution
        
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left=helper(nums,left,rootIndex-1);
        root.right=helper(nums,rootIndex+1,right);
        
        return root;
    }
}
