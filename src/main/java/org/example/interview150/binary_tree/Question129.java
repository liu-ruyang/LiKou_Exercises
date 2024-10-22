package org.example.interview150.binary_tree;

public class Question129 {
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.right == null) {
            return cal(root.left, root.val);
        } else if (root.left == null) {
            return cal(root.right, root.val);
        } else {
            return cal(root.left, root.val) + cal(root.right, root.val);
        }
    }

    public int cal(TreeNode node, int preNum) {
        if (node.left == null && node.right == null) {
            return preNum * 10 + node.val;
        } else if (node.right == null) {
            return cal(node.left, preNum * 10 + node.val);
        } else if (node.left == null) {
            return cal(node.right, preNum * 10 + node.val);
        } else {
            return cal(node.left, preNum * 10 + node.val) + cal(node.right, preNum * 10 + node.val);
        }
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
