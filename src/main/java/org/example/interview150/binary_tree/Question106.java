package org.example.interview150.binary_tree;

import java.util.HashMap;

public class Question106 {
    HashMap map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        int[] a = {9, 3, 15, 20, 7};
        int[] b = {9, 15, 7, 20, 3};
        new Question106().buildTree(a, b);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode node = findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
        return node;
    }

    // 构建根节点->构建左子树->构建右子树
    // 左闭右开
    public TreeNode findNode(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart >= postEnd) {
            return null;
        }
        int value = postorder[postEnd - 1];
        TreeNode node = new TreeNode(value);
        // 根元素在中序顺序中的下标
        int rootInIndex = (int) map.get(value);
        node.left = findNode(inorder, inStart, rootInIndex, postorder, postStart, postStart + rootInIndex - inStart);
        node.right = findNode(inorder, rootInIndex + 1, inEnd, postorder, postStart + rootInIndex - inStart, postEnd - 1);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
