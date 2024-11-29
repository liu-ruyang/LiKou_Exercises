package org.example.interview150.one_dim_dp;

import java.util.Arrays;

public class Question322 {
    public static void main(String[] args) {
        int[] a = {2};
        new Question322().coinChange(a, 3);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] >= 10000 ? -1 : dp[amount];
    }
}
