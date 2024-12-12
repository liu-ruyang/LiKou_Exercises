package org.example.niuke_top101.binery_tree;

import java.util.Deque;
import java.util.LinkedList;

public class BM30 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (pRootOfTree != null) stack.push(pRootOfTree);
        TreeNode res = null, pre = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                if (pop.right != null) stack.push(pop.right);
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) stack.push(pop.left);
            } else {
                pop = stack.pop();
                if (res == null) {
                    res = pop;
                    pre = pop;
                } else {
                    pre.right = pop;
                    pop.left = pre;
                    pop.right = null;
                    pre = pop;
                }
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
