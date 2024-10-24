package org.example.interview150.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }

        queue.add(root);
        double sum = 0;
        int n = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            sum += node.val;
            count++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == n) {
                res.add(sum / (double) count);
                count = 0;
                sum = 0;
                n = queue.size();
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
