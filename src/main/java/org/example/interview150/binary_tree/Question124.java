package org.example.interview150.binary_tree;

public class Question124 {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxGain(node.left);
        int right = maxGain(node.right);
        max = Integer.max(max, Integer.max(node.val, Integer.max(Integer.max(left + node.val, right + node.val), left + right + node.val)));

        return Integer.max(node.val, Integer.max(left + node.val, right + node.val));


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
