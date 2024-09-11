package org.example.interview150.array_and_string;

public class Question122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        // 持有股票状态
        dp[0][0] = -prices[0];
        // 不持有股票状态
        dp[0][1] = 0;


        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
