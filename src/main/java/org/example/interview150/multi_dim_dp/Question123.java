package org.example.interview150.multi_dim_dp;

public class Question123 {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 5, 2, 9, 7};
        new Question123().maxProfit(a);
    }

    public int maxProfit(int[] prices) {
        // dp[i][0]
        // dp[i][1] 第一次持有股票
        // dp[i][2] 第一次卖掉过股票
        // dp[i][3] 第二次持有股票
        // dp[i][4] 第二次卖掉过股票
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];      // 注意：第二次买入依赖于第一次卖出的状态，其实相当于第0天第一次买入了，第一次卖出了，然后再买入一次（第二次买入），
        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];
    }
}
