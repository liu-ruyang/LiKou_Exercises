package org.example.interview150.binary_tree;

import java.util.LinkedList;

public class Question230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);

                stack.push(node);
                stack.push(null);

                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                count++;
                if (count == k) {
                    return node.val;
                }
            }
        }
        return -1;
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
