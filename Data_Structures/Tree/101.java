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
    public boolean isSymmetric(TreeNode root){
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1==null && t2==null) return true;
        if (t1==null || t2==null) return false;
        return (t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
        
    }
    
    /*
    // Time O(N)
    // Space O(N)
    // Approach check if leftmost node's height equals rightmost node's height (oftentimes a problem will occur in InOrder)
    // Then create a InOrder list to check if n element and (size - n - 1) element are the same
    List<Integer> inO = new ArrayList<>();
    int balance = 0;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode curL = root, curR = root;
        int balance = 0;
        while (curL.left!=null){
            curL = curL.left;
            balance++;
        }
        while (curR.right!=null){
            curR = curR.right;
            balance--;
        }
        if (balance != 0) return false;
        System.out.print(balance);
        helper(root);
        for (int i=0;i<inO.size();i++){
            if (inO.get(i) != inO.get(inO.size() - i - 1)) return false;
        }
        return true;
    }
    public void helper(TreeNode root){
        if (root == null) return;
        helper(root.left);
        inO.add(root.val);
        helper(root.right);
        
    }*/
    
}