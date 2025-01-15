package org.example.hot100.dp;

import java.util.Arrays;

public class Question322 {
    public static void main(String[] args) {
        int[] a = {474, 83, 404, 3};
        new Question322().coinChange(a, 264);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    if (dp[i - coins[j]] < Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
