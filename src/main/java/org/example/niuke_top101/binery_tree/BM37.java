package org.example.niuke_top101.binery_tree;

public class BM37 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param p    int整型
     * @param q    int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        if (root == null) return -1;
        if (root.val == p) return root.val;
        if (root.val == q) return root.val;

        int left = lowestCommonAncestor(root.left, p, q);
        int right = lowestCommonAncestor(root.right, p, q);

        if (left != -1 && right != -1) return root.val;
        if (left != -1 && right == -1) return root.left.val;
        if (left == -1 && right != -1) return root.right.val;

        return -1;
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
