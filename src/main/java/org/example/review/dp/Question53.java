package org.example.review.dp;

public class Question53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];

        dp[0] = 0;

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
