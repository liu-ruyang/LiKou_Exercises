package org.example.hot100.bineryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            } else {
                pop = stack.pop();
                res.add(pop.val);
            }
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
