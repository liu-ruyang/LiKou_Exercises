package org.example.niuke_top101.binery_tree;

public class BM40 {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};
        new BM40().reConstructBinaryTree(a, b);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        // write code here
        TreeNode root = constructBinaryTree(preOrder, vinOrder, 0, preOrder.length - 1,
                0, vinOrder.length - 1);
        return root;
    }

    public TreeNode constructBinaryTree(int[] preOrder, int[] vinOrder, int leftPre,
                                        int rightPre, int leftVin, int rightVin) {
        if (leftVin == rightVin) {
            return new TreeNode(vinOrder[leftVin]);
        }

        for (int i = leftVin; i <= rightVin; i++) {
            if (preOrder[leftPre] == vinOrder[i]) {
                TreeNode root = new TreeNode(preOrder[leftPre]);
                TreeNode left = constructBinaryTree(preOrder, vinOrder, leftPre + 1,
                        leftPre + i - leftVin, leftVin, i - 1);
                TreeNode right = constructBinaryTree(preOrder, vinOrder,
                        leftPre + i - leftVin + 1, rightPre, i + 1, rightVin);
                root.left = left;
                root.right = right;
                return root;
            }
        }
        // 在一个空区间根据前序、后序构建树
        return null;
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
