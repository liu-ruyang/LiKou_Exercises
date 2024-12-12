package org.example.niuke_top101.binery_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BM25 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] postorderTraversal(TreeNode root) {
        // write code here
        // write code here
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                stack.push(pop);
                stack.push(null);
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                list.add(pop.val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
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
