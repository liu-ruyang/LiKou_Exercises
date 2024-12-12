package org.example.niuke_top101.binery_tree;

import java.util.Deque;
import java.util.LinkedList;

public class BM28 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        // write code here
        Deque stack = new LinkedList<>();
        int res = 0;
        if (root != null) {
            root.val = 1;
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode pop = (TreeNode) stack.pop();
            if (pop != null) {
                if (pop.right != null) {
                    pop.right.val = pop.val + 1;
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    pop.left.val = pop.val + 1;
                    stack.push(pop.left);
                }
                stack.push(pop);
                stack.push(null);
            } else {
                pop = (TreeNode) stack.pop();
                res = Math.max(res, pop.val);
            }
        }
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
