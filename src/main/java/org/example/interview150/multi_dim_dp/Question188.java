package org.example.interview150.multi_dim_dp;

public class Question188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k * 2 + 1]; // dp[i][j]，j为0为无任何操作，j为奇数为持有状态，j为偶数为不持有状态
        for (int j = 1; j < dp[0].length; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j % 2 != 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[dp.length - 1][k * 2];
    }
}
