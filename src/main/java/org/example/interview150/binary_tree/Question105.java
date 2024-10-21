package org.example.interview150.binary_tree;

import java.util.HashMap;

public class Question105 {
    HashMap map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode node = traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return node;
    }

    public TreeNode traversal(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 左闭右开
        if (preStart >= preEnd) {
            return null;
        }

        int rootIndex = (int) map.get(preorder[preStart]);

        TreeNode node = new TreeNode(preorder[preStart]);
        node.left = traversal(preorder, preStart + 1, preStart + 1 + rootIndex - inStart, inorder, inStart, rootIndex - 1);
        node.right = traversal(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd);

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
