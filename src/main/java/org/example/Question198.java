package org.example;

public class Question198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            if (i == 1)
                dp[i] = nums[i - 1];
            else
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
