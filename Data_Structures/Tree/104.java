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
    //Top-Down
    // Time O(N)
    // Space O(logN)
    private int anw;
    public int maxDepth(TreeNode root) {
        helper(root,1);
        return anw;
    }
    public void helper(TreeNode root, int depth){
        if (root == null) return;
        if (root.left == null && root.right == null) anw = Math.max(anw,depth);
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
        //return anw;
    }
    /*
    //Bottom-Up
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }*/

}