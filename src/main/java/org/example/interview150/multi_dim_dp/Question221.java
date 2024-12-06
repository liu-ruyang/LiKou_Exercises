package org.example.interview150.multi_dim_dp;

public class Question221 {
    public int maximalSquare(char[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = Integer.MIN_VALUE;

        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(res, dp[i][0]);
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            res = Math.max(res, dp[0][j]);
        }
        // 遍历
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = matrix[i][j] == '1' ? Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
