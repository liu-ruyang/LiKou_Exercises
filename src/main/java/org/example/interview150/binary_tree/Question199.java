package org.example.interview150.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = queue.size();
        int count = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.pop();
            count++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == sum) {
                res.add(node.val);
                count = 0;
                sum = queue.size();
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
