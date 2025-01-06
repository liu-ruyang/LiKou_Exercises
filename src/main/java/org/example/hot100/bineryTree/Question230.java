package org.example.hot100.bineryTree;

import java.util.LinkedList;

public class Question230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                if (k-- == 1) return pop.val;
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
