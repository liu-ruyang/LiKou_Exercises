package org.example.dp;

public class Question309 {
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][4];

        // 持有状态（持有、买入）
        dp[0][0] = -prices[0];
        // 保持卖出状态
        dp[0][1] = 0;
        // 今天卖出状态
        dp[0][2] = 0;
        // 冻结状态
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(Math.max(dp[prices.length - 1][3], dp[prices.length - 1][1]), dp[prices.length - 1][2]);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];

        // 持有状态（持有、买入）
        dp[0][0] = -prices[0];
        // 保持卖出状态（包括冻结状态）（此状态可再购）
        dp[0][1] = 0;
        // 卖出状态（下一天冻结）
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
//        return dp[prices.length - 1][1];
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
