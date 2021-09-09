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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        targetSum-=root.val;
        if(root.left == null && root.right==null) return targetSum == 0;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right,targetSum);
    }
    /*
    // Time O(N)
    // Space O(N)
    // Approach check every path and find its sum
    boolean anw = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return anw;
        helper(root,targetSum, 0);
        return anw;
    }
    public void helper(TreeNode root, int targetSum, int subSum){
        System.out.println(subSum);
        //if (anw == true) return;
        // Check if it is leaf node
        if(root.left == null && root.right==null){
            if(subSum+root.val==targetSum) anw = true;
            return;
        }
        if(root.left!=null)helper(root.left,targetSum, subSum + root.val);
        if(root.right!=null)helper(root.right,targetSum, subSum + root.val);
    }
    */
}