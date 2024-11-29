package org.example.interview150.one_dim_dp;

public class Question198 {
    public int rob(int[] nums) {
        // dp[i][0]代表不偷第i间可获最大利，dp[i][1]代表偷第i间可获最大利
        int[][] dp = new int[nums.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }

        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
