package org.example.dp;

public class Question96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[i - 1 - j] * dp[j];
            }
        }
        return dp[n];
    }
}
