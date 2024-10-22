package org.example.interview150.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

public class Question114 {
    public void flatten(TreeNode root) {

        Deque stack = new LinkedList<>();
        stack.push(root);

        TreeNode res = new TreeNode();
        TreeNode pre = res;


        while (!stack.isEmpty()) {
            TreeNode pop = (TreeNode) stack.pop();
            pre.right = pop;

            while (pop != null) {
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                pre = pop;
                pop.right = pop.left;
                pop = pop.left;
                pre.left = null;
            }
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
