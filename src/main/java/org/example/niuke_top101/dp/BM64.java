package org.example.niuke_top101.dp;

public class BM64 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs(int[] cost) {
        // write code here
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            if (i == 1) {
                dp[i] = cost[i];
            } else {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
