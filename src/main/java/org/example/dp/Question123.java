package org.example.dp;

public class Question123 {
    public int maxProfit(int[] prices) {
        // 一天一共就有五个状态，
        //
        // 0:没有操作 （其实我们也可以不设置这个状态）
        // 1:第一次持有股票
        // 2:第一次不持有股票
        // 3:第二次持有股票
        // 4:第二次不持有股票
        int[][] dp = new int[prices.length][5];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return Math.max(Math.max(Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]), Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3])), dp[prices.length - 1][4]);
    }
}
