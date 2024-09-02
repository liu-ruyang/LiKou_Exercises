package org.example.dp;

public class Question122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];


        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        for (int i = 1; i < prices.length; i++) {
            // dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);   // 121
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);    // 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
