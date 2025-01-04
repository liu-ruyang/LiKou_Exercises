package org.example.hot100.bineryTree;

public class Question543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = getDepthAndMaxDistance(root);
        return Math.max(res[0], res[1]) - 1;
    }

    public int[] getDepthAndMaxDistance(TreeNode root) {
        int[] res = new int[2]; // res[0]存储最大深度，res[1]存储以root为根的树的最大直径
        if (root == null) {
            return res;
        }
        int[] left = getDepthAndMaxDistance(root.left);
        int[] right = getDepthAndMaxDistance(root.right);
        res[0] = Math.max(left[0], right[0]) + 1;
        res[1] = Math.max(left[0] + right[0] + 1, Math.max(left[1], right[1]));
        return res;
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
