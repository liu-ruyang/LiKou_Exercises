package org.example.dp;

public class Question337 {
    public int rob(TreeNode root) {
        int[] dp = robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    // 返回当前节点选与不选情况的最大收益 下标0：不选； 下标1：选
    public int[] robTree(TreeNode root) {
        int[] dp = {0, 0};
        if (root == null)
            return dp;

        int[] leftDps = robTree(root.left);
        int[] rightDps = robTree(root.right);

        // ①不选
        // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
        dp[0] = Math.max(leftDps[0], leftDps[1]) + Math.max(rightDps[0], rightDps[1]);
        // ②选
        // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
        dp[1] = leftDps[0] + rightDps[0] + root.val;
        return dp;
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
