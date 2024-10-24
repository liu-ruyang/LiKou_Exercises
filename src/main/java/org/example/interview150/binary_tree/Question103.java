package org.example.interview150.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }

        queue.add(root);
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        int n = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            count++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == n) {
                count = 0;
                if (flag) {
                    res.add(list);
                } else {
                    Collections.reverse(list);
                    res.add(list);
                }
                flag = !flag;
                list = new ArrayList<>();
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
