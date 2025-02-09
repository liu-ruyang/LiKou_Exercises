package org.example.review.dp;

import java.util.Arrays;

public class Question494 {
    public static void main(String[] args) {
        // int[] a = {1};
        // int[] a = {7, 9, 3, 8, 0, 2, 4, 8, 3, 9};
        int[] a = {100};
        System.out.println(new Question494().findTargetSumWays(a, -200));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum + target) % 2 != 0) {
            return 0;
        }

        int total = (sum + target) / 2;
        if (total < 0) {
            return 0;
        }


        int[] dp = new int[total + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j - nums[i]] + dp[j];
                }
            }
        }

        return dp[total];
    }
}
