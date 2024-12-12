package org.example.niuke_top101.binery_tree;

import java.util.Deque;
import java.util.LinkedList;

public class BM36 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        // write code here
        Deque<TreeNode> stack = new LinkedList<>();
        if (pRoot != null) stack.push(pRoot);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                stack.push(pop);
                stack.push(null);
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                if (pop.left == null && pop.right == null) pop.val = 1;
                else if (pop.left == null && pop.right != null) {
                    if (pop.right.val > 1) return false;
                    pop.val = pop.right.val + 1;
                } else if (pop.left != null && pop.right == null) {
                    if (pop.left.val > 1) return false;
                    pop.val = pop.left.val + 1;
                } else {
                    if (Math.abs(pop.left.val - pop.right.val) > 1) return false;
                    pop.val = Math.max(pop.left.val, pop.right.val) + 1;
                }
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

