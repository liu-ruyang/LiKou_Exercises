package org.example.hot100.bineryTree;

public class Question124 {
    public int maxPathSum(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];      // 0处存储当前节点出发的最大单向路径，1存储当前当前节点为根节点的树的最大路径
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];

        if (left[0] > 0 && right[0] > 0) {
            res[0] = Math.max(left[0], right[0]) + root.val;
        } else if (left[0] <= 0 && right[0] > 0) {
            res[0] = right[0] + root.val;
        } else if (left[0] > 0 && right[0] <= 0) {
            res[0] = left[0] + root.val;
        } else if (left[0] <= 0 && right[0] <= 0) {
            res[0] = root.val;
        }

        if (left[0] > 0 && right[0] > 0) {
            res[1] = Math.max(Math.max(left[1], right[1]), left[0] + right[0] + root.val);
        } else if (left[0] <= 0 && right[0] > 0) {
            res[1] = Math.max(Math.max(left[1], right[1]), right[0] + root.val);
        } else if (left[0] > 0 && right[0] <= 0) {
            res[1] = Math.max(Math.max(left[1], right[1]), left[0] + root.val);
        } else if (left[0] <= 0 && right[0] <= 0) {
            if (root.left == null && root.right == null) {
                res[1] = root.val;
            } else if (root.left == null && root.right != null) {
                res[1] = Math.max(right[1], root.val);
            } else if (root.left != null && root.right == null) {
                res[1] = Math.max(left[1], root.val);
            } else if (root != null && root.right != null) {
                res[1] = Math.max(Math.max(left[1], right[1]), root.val);
            }
        }

//        res[0] = Math.max(left[0], right[0]) + root.val;
//        res[1] = Math.max(Math.max(left[1], right[1]), left[0] + right[0] + root.val);

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
