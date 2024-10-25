package org.example.interview150.binary_tree;

import java.util.LinkedList;

public class Question98 {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        boolean first = true;
        int pre = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);

                stack.push(node);
                stack.push(null);

                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                if (first) {
                    pre = node.val;
                    first = false;
                } else if (node.val <= pre) {
                    return false;
                } else {
                    pre = node.val;
                }
            }
        }

        return true;
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
