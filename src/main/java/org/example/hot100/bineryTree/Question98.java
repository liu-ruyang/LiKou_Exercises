package org.example.hot100.bineryTree;

import java.util.LinkedList;

public class Question98 {
    // 中序遍历
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        long temp = Long.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                if (temp >= pop.val) return false;
                temp = pop.val;
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
