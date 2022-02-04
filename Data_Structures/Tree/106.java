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
    Map<Integer, Integer> inMap;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inMap = new HashMap<>();
        postIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreOrder(postorder, 0, postorder.length - 1);
    }
    public TreeNode buildPreOrder(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[postIdx--];
        TreeNode root = new TreeNode(val);
        root.right = buildPreOrder(preorder, inMap.get(val) + 1, right);
        root.left = buildPreOrder(preorder, left, inMap.get(val) - 1);
        return root;
    }
}
/*
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildNode(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd) 
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        if (postStart == postEnd) 
            return root;
        
        int idx = inStart;
        while (inorder[idx] != postorder[postEnd]){
            idx++;
        }
        root.left = buildNode(inorder, inStart, idx - 1, postorder, postStart, postStart + (idx - 1 - inStart));
        root.right = buildNode(inorder, idx + 1, inEnd, postorder, postEnd - 1 - (inEnd - (idx + 1)), postEnd - 1);
        return root;
    }
}
*/