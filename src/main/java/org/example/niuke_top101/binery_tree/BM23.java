package org.example.niuke_top101.binery_tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BM23 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal(TreeNode root) {
        // write code here
        Deque stack = new LinkedList<>();
        if (root != null) stack.push(root);
        List res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = (TreeNode) stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
                stack.push(pop);
                stack.push(null);
            } else {
                pop = (TreeNode) stack.pop();
                res.add(pop.val);
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) res.get(i);
        }
        return array;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
