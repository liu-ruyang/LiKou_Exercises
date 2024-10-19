package org.example.interview150.binary_tree;

public class Question104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }

        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }

        return Integer.max(leftDepth, rightDepth) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
