package org.example;

public class Question509 {

    /**
     * 1. 确定dp数组以及下标含义
     * 2. 确定地推公式
     * 3. dp数组如何初始化
     * 4. 确定遍历顺序
     * 5. 举例推到dp数组
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
