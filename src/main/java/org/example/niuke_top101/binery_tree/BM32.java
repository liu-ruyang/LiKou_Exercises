package org.example.niuke_top101.binery_tree;

public class BM32 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        return merge(t1, t2);
    }

    public TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 != null && node2 == null) {
            return node1;
        }
        if (node1 == null && node2 != null) {
            return node2;
        }
        node1.val += node2.val;
        node1.left = merge(node1.left, node2.left);
        node1.right = merge(node1.right, node2.right);
        return node1;
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
