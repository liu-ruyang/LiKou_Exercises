package org.example.interview150.binary_tree;

public class Question222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
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
