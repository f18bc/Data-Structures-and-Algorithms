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
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        idx = 0;
        for (int i = 0; i < preorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreOrder(preorder, 0, preorder.length - 1);
    }
    public TreeNode buildPreOrder(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        root.left = buildPreOrder(preorder, left, inMap.get(val) - 1);
        root.right = buildPreOrder(preorder, inMap.get(val) + 1, right);
        return root;
    }
}

 /*
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd) 
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) 
            return root;
        
        int idx = inStart;
        while (inorder[idx] != preorder[preStart]){
            idx++;
        }
        root.left = buildNode(preorder, preStart + 1, preStart + 1 + idx - inStart - 1, inorder, inStart, idx - 1);
        root.right = buildNode(preorder, preStart + 1 + idx - inStart, preEnd, inorder, idx + 1, inEnd);
        return root;
    }
}
*/