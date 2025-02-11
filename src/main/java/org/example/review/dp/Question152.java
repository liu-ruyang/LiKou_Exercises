package org.example.review.dp;

import java.util.Arrays;

public class Question152 {
    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4};
        new Question152().maxProduct(a);
    }

    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = dp[0][1] = nums[0];

        int res = dp[0][0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }

    // public int maxProduct(int[] nums) {
    //     int[][] dp = new int[nums.length][nums.length];
    //
    //     int res = Integer.MIN_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         dp[i][i] = nums[i];
    //         res = Math.max(res, nums[i]);
    //     }
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             dp[i][j] = dp[i][j - 1] * nums[j];
    //             res = Math.max(res, dp[i][j]);
    //         }
    //     }
    //     return res;
    // }
}
