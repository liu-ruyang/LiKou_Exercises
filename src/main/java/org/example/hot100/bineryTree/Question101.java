package org.example.hot100.bineryTree;

public class Question101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(invertTree(root.left), root.right);
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null || root1 != null && root2 == null || root1 != null && root2 != null && root1.val != root2.val) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
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
