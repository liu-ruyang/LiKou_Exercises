package org.example.hot100.bineryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        int count = queue.size();
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop.left != null) queue.add(pop.left);
            if (pop.right != null) queue.add(pop.right);
            if (--count == 0) {
                res.add(pop.val);
                count = queue.size();
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
