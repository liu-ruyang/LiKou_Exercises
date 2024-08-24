package org.example.dp;

public class Question746 {

    /**
     * 1.确定dp数组以及下标含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
