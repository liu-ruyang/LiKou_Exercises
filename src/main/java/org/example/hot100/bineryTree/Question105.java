package org.example.hot100.bineryTree;

public class Question105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 寻找根节点
        int rootVal = preorder[preorderLeft];
        TreeNode root = new TreeNode(rootVal);
        // 寻找根节点在中序遍历中的下标
        int rootIndex = -1;
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 处理左子树
        TreeNode left = build(preorder, inorder, preorderLeft + 1, preorderLeft + rootIndex - inorderLeft, inorderLeft, rootIndex - 1);
        // 处理右子树
        TreeNode right = build(preorder, inorder, preorderLeft + rootIndex - inorderLeft + 1, preorderRight, rootIndex + 1, inorderRight);
        root.left = left;
        root.right = right;
        return root;
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
