package org.example.niuke_top101.binery_tree;

import java.util.Deque;
import java.util.LinkedList;

public class BM34 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST(TreeNode root) {
        // write code here
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                if (pop.val < pre) return false;
                pre = pop.val;
            }
        }
        return true;
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
