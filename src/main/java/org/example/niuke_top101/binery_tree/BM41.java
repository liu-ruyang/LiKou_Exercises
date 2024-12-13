package org.example.niuke_top101.binery_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BM41 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 求二叉树的右视图
     *
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder  int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] preOrder, int[] inOrder) {
        // write code here
        TreeNode root = constructBinaryTree(preOrder, inOrder, 0, preOrder.length - 1,
                0, inOrder.length - 1);

        List list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int len = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            len--;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (len == 0) {
                list.add(node.val);
                len = queue.size();
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = (int) list.get(i);
        }
        return res;
    }

    public TreeNode constructBinaryTree(int[] preOrder, int[] vinOrder,
                                        int leftPre,
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
