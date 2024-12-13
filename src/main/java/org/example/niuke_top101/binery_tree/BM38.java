package org.example.niuke_top101.binery_tree;

public class BM38 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        if (root == null) return -1;
        if (root.val == o1) return root.val;
        if (root.val == o2) return root.val;

        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);

        if (left != -1 && right != -1) return root.val;
        if (left != -1 && right == -1) return left;
        if (left == -1 && right != -1) return right;
        
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
