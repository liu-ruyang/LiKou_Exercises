package org.example;

/**
 * 1. 确定dp数组及下标含义
 * 2. 确定递推公式
 * 3. dp数组如何初始化
 * 4. 确定dp数组遍历顺序
 * 5. 举例推导dp数组
 */
public class Question279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
