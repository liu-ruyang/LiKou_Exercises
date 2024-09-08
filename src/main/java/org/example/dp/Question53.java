package org.example.dp;

public class Question53 {
    public int maxSubArray(int[] nums) {
        // dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
                max = Math.max(max, dp[i]);
            } else {
                dp[i] = nums[i];
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
