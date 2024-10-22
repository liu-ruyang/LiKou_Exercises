package org.example.interview150.binary_tree;

public class Question112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return findPath(root, targetSum, 0);
    }

    public boolean findPath(TreeNode node, int targetSum, int sum) {
        if (node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }

        sum += node.val;
        if (sum > targetSum) {
            return false;
        }

        boolean left = false;
        if (node.left != null) {
            left = findPath(node.left, targetSum, sum);
        }

        boolean right = false;
        if (node.right != null) {
            right = findPath(node.right, targetSum, sum);
        }
        return left || right;
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
