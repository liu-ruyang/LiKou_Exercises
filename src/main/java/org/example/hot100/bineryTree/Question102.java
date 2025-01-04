package org.example.hot100.bineryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode pop = queue.pop();
                list.add(pop.val);
                count--;
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            count = queue.size();
            res.add(list);
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
