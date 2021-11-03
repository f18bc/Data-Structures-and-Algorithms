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
    // Double O(n)
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    public int[] helper(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        
        // 0 do not steal
        // 1 do not steal
        result[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        result[1] = l[0] + r[0] + root.val;
        return result;
    }
    /*
    Map<TreeNode, Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return helper(root);
    }
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += helper(root.left.left) + helper(root.left.right);
        }
        if (root.right != null) {
            money += helper(root.right.left) + helper(root.right.right);
        }

        int result = Math.max(money, (helper(root.left) + helper(root.right)));
        map.put(root, result);
        return result;
    }
    */
}