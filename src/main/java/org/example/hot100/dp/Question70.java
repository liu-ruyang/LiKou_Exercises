package org.example.hot100.dp;

public class Question70 {
//    普通递归动态规划：超时
//    public int climbStairs(int n) {
//        if (n == 0 || n == 1) return 1;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    // 一维数组动态规划
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
