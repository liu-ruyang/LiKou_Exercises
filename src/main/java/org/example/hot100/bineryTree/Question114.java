package org.example.hot100.bineryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
                stack.push(pop);
                stack.push(null);
            } else {
                pop = stack.pop();
                res.add(pop);
            }
        }
        TreeNode pre = res.get(0);
        pre.left = null;
        for (int i = 1; i < res.size(); i++) {
            pre.right = res.get(i);
            res.get(i).left = null;
            pre = res.get(i);
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
