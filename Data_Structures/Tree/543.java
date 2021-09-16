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
    /*
    private int distance = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return distance;
    }
    public int maxDepth(TreeNode root){
        if(root==null)return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
    public void helper(TreeNode root){
        if(root==null)return;
        int left = root.left==null ? 0 : maxDepth(root.left);
        int right = root.right==null ? 0 : maxDepth(root.right);
        if((left+right)>distance) distance =left+right;
        helper(root.left);
        helper(root.right);
    }
    */
    private int distance = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return distance;
    }
    public int helper(TreeNode root){
        if(root==null)return 0;
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        distance = Math.max(distance, leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
    
}