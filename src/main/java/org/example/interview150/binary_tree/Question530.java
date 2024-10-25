package org.example.interview150.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question530 {
    public int getMinimumDifference(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();

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
                list.add(node.val);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            res = Math.min(Math.abs(list.get(i) - list.get(i + 1)), res);
        }
        return res;
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
