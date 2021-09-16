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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<>();
        String s = String.valueOf(root.val);
        helper(root,l,s);
        return l;
    }
    public void helper(TreeNode root, List<String> l, String s){
        if(root.left==null && root.right==null) l.add(s);
        if(root.left!=null)helper(root.left, l, s + "->" + String.valueOf(root.left.val));
        if(root.right!=null)helper(root.right, l, s + "->" + String.valueOf(root.right.val));
    }
}