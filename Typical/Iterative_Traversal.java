public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        ans.add(root.val);
        root = root.right;
    }
    return ans;
}

// 1
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            ans.add(root.val);
            root = root.left;
        }
        root = stack.pop();

        root = root.right;
    }
    return ans;
}


// 2
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    if (root != null) {
        stack.push(root);
    }
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        ans.add(node.val);
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }
    return ans;
}

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (root.right == null || prev == root.right) {
            ans.add(root.val);
            prev = root;
            root = null;
        } else {
            stack.push(root);
            root = root.right;
        }
    }
    return ans;
}
