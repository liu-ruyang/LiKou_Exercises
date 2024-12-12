package org.example.niuke_top101.binery_tree;

import java.util.Deque;
import java.util.LinkedList;

public class BM33 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        Deque<TreeNode> stack = new LinkedList<>();
        if (pRoot != null) stack.push(pRoot);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                TreeNode tmp = pop.left;
                pop.left = pop.right;
                pop.right = tmp;
            }
        }
        return pRoot;
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
