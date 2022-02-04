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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildNode(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildNode(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if (preStart > preEnd) 
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) 
            return root;
        
        int idx = postStart;
        while (postorder[idx] != preorder[preStart+1]){
            idx++;
        }
        root.left = buildNode(preorder, preStart + 1, preStart + 1 + idx - postStart, postorder, postStart, idx);
        root.right = buildNode(preorder, preStart + 1 + idx - postStart + 1, preEnd, postorder, idx + 1, postEnd - 1);
        return root;
    }
}