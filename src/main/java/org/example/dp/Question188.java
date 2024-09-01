package org.example.dp;

public class Question188 {
    public static void main(String[] args) {
        int[] a = {2, 4, 1};
        new Question188().maxProfit(2, a);
    }

    public int maxProfit(int k, int[] prices) {
        // 一天一共就有五个状态，
        //
        // 0:没有操作 （其实我们也可以不设置这个状态）
        // 1:第一次持有股票
        // 2:第一次不持有股票
        // 3:第二次持有股票
        // 4:第二次不持有股票
        // int[][] dp = new int[prices.length][k * 2 + 1];
        int[][] dp = new int[prices.length][k * 2 + 1];

        for (int i = 0; i < dp[0].length; i++) {
            if (i % 2 != 0) {
                dp[0][i] = -prices[0];
            } else {
                dp[0][i] = 0;
            }
        }


        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j % 2 != 0) {   // 第j次持有
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {    // 第j次不持有
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        // int res = Integer.MIN_VALUE;
        // for (int i = 0; i < dp[prices.length - 1].length; i++) {
        //     res = res > dp[prices.length - 1][i] ? res : dp[prices.length - 1][i];
        // }
        // return res;
        
        return dp[prices.length - 1][2 * k];
    }
}
