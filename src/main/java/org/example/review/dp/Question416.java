package org.example.review.dp;

import java.util.Arrays;

public class Question416 {
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1};
        new Question416().canPartition(a);
    }

    public boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 != 0) {
            return false;
        }

        int sum = Arrays.stream(nums).sum() / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= nums[i] && dp[j - nums[i]])
                    dp[j] = dp[j - nums[i]];
            }
        }

        return dp[sum];
    }
}
